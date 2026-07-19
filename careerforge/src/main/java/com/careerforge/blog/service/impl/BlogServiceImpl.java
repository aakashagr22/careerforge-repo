package com.careerforge.blog.service.impl;

import com.careerforge.blog.dto.BlogDto;
import com.careerforge.blog.dto.CreateBlogRequest;
import com.careerforge.blog.dto.RejectBlogRequest;
import com.careerforge.blog.dto.UpdateBlogRequest;
import com.careerforge.blog.entity.Blog;
import com.careerforge.blog.entity.BlogStatus;
import com.careerforge.blog.repository.BlogRepository;
import com.careerforge.blog.service.BlogService;
import com.careerforge.exception.BadRequestException;
import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.student.repository.StudentProfileRepository;
import com.careerforge.user.entity.User;
import com.careerforge.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;
    private final StudentProfileRepository studentProfileRepository;

    @Override
    @Transactional
    public BlogDto createStudentBlog(CreateBlogRequest request, UUID studentId) {
        User author = userRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student user not found"));

        StudentProfile profile = studentProfileRepository.findByUserId(studentId)
                .orElseThrow(() -> new BadRequestException("Student profile not found. Please complete profile registration."));

        Integer semester = profile.getSemester();
        if (semester == null || semester < 3 || semester > 8) {
            throw new BadRequestException("Only students in their 2nd to 4th year (semester 3 to 8) are eligible to write blogs.");
        }

        Blog blog = Blog.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(author)
                .status(request.isSubmitForReview() ? BlogStatus.PENDING_REVIEW : BlogStatus.DRAFT)
                .build();

        Blog savedBlog = blogRepository.save(blog);
        log.info("Student blog created with ID: {} and status: {}", savedBlog.getId(), savedBlog.getStatus());
        return toDto(savedBlog);
    }

    @Override
    @Transactional
    public BlogDto createAdminBlog(CreateBlogRequest request, UUID adminId) {
        User admin = userRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin user not found"));

        Blog blog = Blog.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(admin)
                .status(BlogStatus.PUBLISHED)
                .approvedBy(admin)
                .approvedAt(LocalDateTime.now())
                .build();

        Blog savedBlog = blogRepository.save(blog);
        log.info("Admin blog auto-published immediately with ID: {}", savedBlog.getId());
        return toDto(savedBlog);
    }

    @Override
    @Transactional
    public BlogDto updateStudentBlog(UUID blogId, UpdateBlogRequest request, UUID studentId) {
        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));

        if (blog.getAuthor() == null || !blog.getAuthor().getId().equals(studentId)) {
            throw new BadRequestException("You are not authorized to update this blog.");
        }

        if (blog.getStatus() != BlogStatus.DRAFT && blog.getStatus() != BlogStatus.REJECTED) {
            throw new BadRequestException("You can only edit blogs that are in DRAFT or REJECTED status.");
        }

        blog.setTitle(request.getTitle());
        blog.setContent(request.getContent());
        
        if (request.isSubmitForReview()) {
            blog.setStatus(BlogStatus.PENDING_REVIEW);
            blog.setRejectionReason(null);
        } else {
            blog.setStatus(BlogStatus.DRAFT);
        }

        Blog updatedBlog = blogRepository.save(blog);
        log.info("Student blog updated with ID: {} and new status: {}", updatedBlog.getId(), updatedBlog.getStatus());
        return toDto(updatedBlog);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BlogDto> getPublishedBlogs(Pageable pageable) {
        return blogRepository.findByStatusOrderByCreatedAtDesc(BlogStatus.PUBLISHED, pageable)
                .map(this::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BlogDto> getMyBlogs(UUID authorId, Pageable pageable) {
        return blogRepository.findByAuthorIdOrderByCreatedAtDesc(authorId, pageable)
                .map(this::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BlogDto> getPendingBlogs(Pageable pageable) {
        return blogRepository.findByStatusOrderByCreatedAtAsc(BlogStatus.PENDING_REVIEW, pageable)
                .map(this::toDto);
    }

    @Override
    @Transactional
    public BlogDto approveBlog(UUID blogId, UUID adminId) {
        User admin = userRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin user not found"));

        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));

        if (blog.getStatus() != BlogStatus.PENDING_REVIEW) {
            throw new BadRequestException("Only blogs in PENDING_REVIEW status can be approved.");
        }

        blog.setStatus(BlogStatus.PUBLISHED);
        blog.setApprovedBy(admin);
        blog.setApprovedAt(LocalDateTime.now());
        blog.setRejectionReason(null);

        Blog approvedBlog = blogRepository.save(blog);
        log.info("Blog approved and published with ID: {} by admin: {}", approvedBlog.getId(), adminId);
        return toDto(approvedBlog);
    }

    @Override
    @Transactional
    public BlogDto rejectBlog(UUID blogId, RejectBlogRequest request, UUID adminId) {
        userRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin user not found"));

        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));

        if (blog.getStatus() != BlogStatus.PENDING_REVIEW && blog.getStatus() != BlogStatus.PUBLISHED) {
            throw new BadRequestException("Only blogs in PENDING_REVIEW or PUBLISHED status can be rejected.");
        }

        blog.setStatus(BlogStatus.REJECTED);
        blog.setRejectionReason(request.getRejectionReason());

        Blog rejectedBlog = blogRepository.save(blog);
        log.info("Blog rejected with ID: {} by admin: {}", rejectedBlog.getId(), adminId);
        return toDto(rejectedBlog);
    }

    @Override
    @Transactional(readOnly = true)
    public BlogDto getBlogById(UUID id) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
        return toDto(blog);
    }

    private BlogDto toDto(Blog blog) {
        String authorName = "Anonymous Author";
        UUID authorId = null;
        if (blog.getAuthor() != null) {
            authorId = blog.getAuthor().getId();
            authorName = blog.getAuthor().getFirstName() + " " + blog.getAuthor().getLastName();
        }

        String approvedByName = null;
        if (blog.getApprovedBy() != null) {
            approvedByName = blog.getApprovedBy().getFirstName() + " " + blog.getApprovedBy().getLastName();
        }

        return BlogDto.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .content(blog.getContent())
                .status(blog.getStatus().name())
                .authorId(authorId)
                .authorName(authorName)
                .createdAt(blog.getCreatedAt())
                .updatedAt(blog.getUpdatedAt())
                .approvedAt(blog.getApprovedAt())
                .approvedBy(approvedByName)
                .rejectionReason(blog.getRejectionReason())
                .build();
    }
}
