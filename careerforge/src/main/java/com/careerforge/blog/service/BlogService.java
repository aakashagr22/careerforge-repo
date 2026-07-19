package com.careerforge.blog.service;

import com.careerforge.blog.dto.BlogDto;
import com.careerforge.blog.dto.CreateBlogRequest;
import com.careerforge.blog.dto.RejectBlogRequest;
import com.careerforge.blog.dto.UpdateBlogRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface BlogService {
    BlogDto createStudentBlog(CreateBlogRequest request, UUID studentId);

    BlogDto createAdminBlog(CreateBlogRequest request, UUID adminId);

    BlogDto updateStudentBlog(UUID blogId, UpdateBlogRequest request, UUID studentId);

    Page<BlogDto> getPublishedBlogs(Pageable pageable);

    Page<BlogDto> getMyBlogs(UUID authorId, Pageable pageable);

    Page<BlogDto> getPendingBlogs(Pageable pageable);

    BlogDto approveBlog(UUID blogId, UUID adminId);

    BlogDto rejectBlog(UUID blogId, RejectBlogRequest request, UUID adminId);

    BlogDto getBlogById(UUID id);
}
