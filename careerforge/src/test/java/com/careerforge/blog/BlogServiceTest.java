package com.careerforge.blog;

import com.careerforge.blog.dto.BlogDto;
import com.careerforge.blog.dto.CreateBlogRequest;
import com.careerforge.blog.dto.RejectBlogRequest;
import com.careerforge.blog.dto.UpdateBlogRequest;
import com.careerforge.blog.entity.Blog;
import com.careerforge.blog.entity.BlogStatus;
import com.careerforge.blog.repository.BlogRepository;
import com.careerforge.blog.service.impl.BlogServiceImpl;
import com.careerforge.exception.BadRequestException;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.student.repository.StudentProfileRepository;
import com.careerforge.user.entity.User;
import com.careerforge.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BlogServiceTest {

    @Mock
    private BlogRepository blogRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private StudentProfileRepository studentProfileRepository;

    @InjectMocks
    private BlogServiceImpl blogService;

    private User studentUser;
    private User adminUser;
    private StudentProfile eligibleProfile;
    private StudentProfile ineligibleProfile;
    private Blog pendingBlog;

    @BeforeEach
    void setUp() {
        studentUser = User.builder()
                .id(UUID.randomUUID())
                .email("student@gmail.com")
                .firstName("Akash")
                .lastName("Kumar")
                .build();

        adminUser = User.builder()
                .id(UUID.randomUUID())
                .email("admin@gmail.com")
                .firstName("Admin")
                .lastName("Forge")
                .build();

        eligibleProfile = StudentProfile.builder()
                .id(UUID.randomUUID())
                .user(studentUser)
                .semester(5)
                .build();

        ineligibleProfile = StudentProfile.builder()
                .id(UUID.randomUUID())
                .user(studentUser)
                .semester(2)
                .build();

        pendingBlog = Blog.builder()
                .id(UUID.randomUUID())
                .title("Graphs Tutorial")
                .content("Graphs content")
                .author(studentUser)
                .status(BlogStatus.PENDING_REVIEW)
                .build();
    }

    @Test
    void createStudentBlog_WithEligibleSemester_ShouldSucceed() {
        CreateBlogRequest request = CreateBlogRequest.builder()
                .title("Graphs Tutorial")
                .content("Graphs content")
                .submitForReview(true)
                .build();

        when(userRepository.findById(studentUser.getId())).thenReturn(Optional.of(studentUser));
        when(studentProfileRepository.findByUserId(studentUser.getId())).thenReturn(Optional.of(eligibleProfile));
        when(blogRepository.save(any(Blog.class))).thenAnswer(invocation -> {
            Blog saved = invocation.getArgument(0);
            saved.setId(UUID.randomUUID());
            return saved;
        });

        BlogDto result = blogService.createStudentBlog(request, studentUser.getId());

        assertNotNull(result);
        assertEquals("Graphs Tutorial", result.getTitle());
        assertEquals("PENDING_REVIEW", result.getStatus());
        assertEquals("Akash Kumar", result.getAuthorName());
    }

    @Test
    void createStudentBlog_WithIneligibleSemester_ShouldThrowBadRequestException() {
        CreateBlogRequest request = CreateBlogRequest.builder()
                .title("Graphs Tutorial")
                .content("Graphs content")
                .submitForReview(true)
                .build();

        when(userRepository.findById(studentUser.getId())).thenReturn(Optional.of(studentUser));
        when(studentProfileRepository.findByUserId(studentUser.getId())).thenReturn(Optional.of(ineligibleProfile));

        assertThrows(BadRequestException.class, () -> 
            blogService.createStudentBlog(request, studentUser.getId())
        );
        verify(blogRepository, never()).save(any(Blog.class));
    }

    @Test
    void createAdminBlog_ShouldAutoPublishImmediately() {
        CreateBlogRequest request = CreateBlogRequest.builder()
                .title("Admin Guidelines")
                .content("Guidelines content")
                .build();

        when(userRepository.findById(adminUser.getId())).thenReturn(Optional.of(adminUser));
        when(blogRepository.save(any(Blog.class))).thenAnswer(invocation -> {
            Blog saved = invocation.getArgument(0);
            saved.setId(UUID.randomUUID());
            return saved;
        });

        BlogDto result = blogService.createAdminBlog(request, adminUser.getId());

        assertNotNull(result);
        assertEquals("Admin Guidelines", result.getTitle());
        assertEquals("PUBLISHED", result.getStatus());
        assertEquals("Admin Forge", result.getAuthorName());
    }

    @Test
    void updateStudentBlog_RejectedToPending_ShouldClearRejectionReason() {
        Blog rejectedBlog = Blog.builder()
                .id(UUID.randomUUID())
                .title("Old Title")
                .content("Old Content")
                .author(studentUser)
                .status(BlogStatus.REJECTED)
                .rejectionReason("Incomplete diagrams")
                .build();

        UpdateBlogRequest request = UpdateBlogRequest.builder()
                .title("New Title")
                .content("New Content")
                .submitForReview(true)
                .build();

        when(blogRepository.findById(rejectedBlog.getId())).thenReturn(Optional.of(rejectedBlog));
        when(blogRepository.save(any(Blog.class))).thenAnswer(invocation -> invocation.getArgument(0));

        BlogDto result = blogService.updateStudentBlog(rejectedBlog.getId(), request, studentUser.getId());

        assertNotNull(result);
        assertEquals("New Title", result.getTitle());
        assertEquals("PENDING_REVIEW", result.getStatus());
        assertNull(result.getRejectionReason());
    }

    @Test
    void approveBlog_PendingReview_ShouldSetPublished() {
        when(userRepository.findById(adminUser.getId())).thenReturn(Optional.of(adminUser));
        when(blogRepository.findById(pendingBlog.getId())).thenReturn(Optional.of(pendingBlog));
        when(blogRepository.save(any(Blog.class))).thenAnswer(invocation -> invocation.getArgument(0));

        BlogDto result = blogService.approveBlog(pendingBlog.getId(), adminUser.getId());

        assertNotNull(result);
        assertEquals("PUBLISHED", result.getStatus());
        assertEquals("Admin Forge", result.getApprovedBy());
    }

    @Test
    void rejectBlog_PendingReview_ShouldSetRejectedWithReason() {
        RejectBlogRequest request = RejectBlogRequest.builder()
                .rejectionReason("Formatting issues")
                .build();

        when(userRepository.findById(adminUser.getId())).thenReturn(Optional.of(adminUser));
        when(blogRepository.findById(pendingBlog.getId())).thenReturn(Optional.of(pendingBlog));
        when(blogRepository.save(any(Blog.class))).thenAnswer(invocation -> invocation.getArgument(0));

        BlogDto result = blogService.rejectBlog(pendingBlog.getId(), request, adminUser.getId());

        assertNotNull(result);
        assertEquals("REJECTED", result.getStatus());
        assertEquals("Formatting issues", result.getRejectionReason());
    }

    @Test
    void rejectBlog_PublishedBlog_ShouldSucceed() {
        Blog publishedBlog = Blog.builder()
                .id(UUID.randomUUID())
                .title("Graphs Tutorial")
                .content("Graphs content")
                .author(studentUser)
                .status(BlogStatus.PUBLISHED)
                .build();

        RejectBlogRequest request = RejectBlogRequest.builder()
                .rejectionReason("Spam content flagged")
                .build();

        when(userRepository.findById(adminUser.getId())).thenReturn(Optional.of(adminUser));
        when(blogRepository.findById(publishedBlog.getId())).thenReturn(Optional.of(publishedBlog));
        when(blogRepository.save(any(Blog.class))).thenAnswer(invocation -> invocation.getArgument(0));

        BlogDto result = blogService.rejectBlog(publishedBlog.getId(), request, adminUser.getId());

        assertNotNull(result);
        assertEquals("REJECTED", result.getStatus());
        assertEquals("Spam content flagged", result.getRejectionReason());
    }

    @Test
    void toDto_WithDeletedUserAuthor_ShouldReturnAnonymousAuthor() {
        Blog orphanedBlog = Blog.builder()
                .id(UUID.randomUUID())
                .title("No Author")
                .content("Content")
                .author(null) // Deleted User
                .status(BlogStatus.PUBLISHED)
                .build();

        when(blogRepository.findById(orphanedBlog.getId())).thenReturn(Optional.of(orphanedBlog));

        BlogDto result = blogService.getBlogById(orphanedBlog.getId());

        assertNotNull(result);
        assertNull(result.getAuthorId());
        assertEquals("Anonymous Author", result.getAuthorName());
    }
}
