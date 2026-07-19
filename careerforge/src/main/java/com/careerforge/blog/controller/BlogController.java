package com.careerforge.blog.controller;

import com.careerforge.blog.dto.BlogDto;
import com.careerforge.blog.dto.CreateBlogRequest;
import com.careerforge.blog.dto.RejectBlogRequest;
import com.careerforge.blog.dto.UpdateBlogRequest;
import com.careerforge.blog.service.BlogService;
import com.careerforge.common.dto.ApiResponse;
import com.careerforge.security.UserPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Tag(name = "Blogs", description = "APIs for student blog composition and admin moderation queue")
public class BlogController {

    private final BlogService blogService;

    // ======================== Student Endpoints ========================

    @PostMapping("/api/student/blogs")
    @Operation(summary = "Create a new blog (Student)")
    public ResponseEntity<ApiResponse<BlogDto>> createStudentBlog(
            @Valid @RequestBody CreateBlogRequest request,
            @AuthenticationPrincipal UserPrincipal principal) {
        BlogDto blog = blogService.createStudentBlog(request, principal.getId());
        return new ResponseEntity<>(ApiResponse.success(blog, "Blog draft/review submitted successfully"), HttpStatus.CREATED);
    }

    @PutMapping("/api/student/blogs/{id}")
    @Operation(summary = "Update an existing draft or rejected blog (Student)")
    public ResponseEntity<ApiResponse<BlogDto>> updateStudentBlog(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateBlogRequest request,
            @AuthenticationPrincipal UserPrincipal principal) {
        BlogDto blog = blogService.updateStudentBlog(id, request, principal.getId());
        return ResponseEntity.ok(ApiResponse.success(blog, "Blog updated successfully"));
    }

    @GetMapping("/api/student/blogs/my")
    @Operation(summary = "Get list of user's own composed blogs (Student)")
    public ResponseEntity<ApiResponse<Page<BlogDto>>> getMyBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @AuthenticationPrincipal UserPrincipal principal) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BlogDto> blogs = blogService.getMyBlogs(principal.getId(), pageable);
        return ResponseEntity.ok(ApiResponse.success(blogs, "My blogs retrieved successfully"));
    }

    @GetMapping("/api/student/blogs")
    @Operation(summary = "Get list of all published blogs (Public Feed - Student & Admin)")
    public ResponseEntity<ApiResponse<Page<BlogDto>>> getPublishedBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BlogDto> blogs = blogService.getPublishedBlogs(pageable);
        return ResponseEntity.ok(ApiResponse.success(blogs, "Published blogs retrieved successfully"));
    }

    @GetMapping("/api/student/blogs/{id}")
    @Operation(summary = "Get detailed blog details (Student)")
    public ResponseEntity<ApiResponse<BlogDto>> getBlogById(@PathVariable UUID id) {
        BlogDto blog = blogService.getBlogById(id);
        return ResponseEntity.ok(ApiResponse.success(blog, "Blog retrieved successfully"));
    }

    // ======================== Admin Endpoints ========================

    @PostMapping("/api/admin/blogs")
    @Operation(summary = "Create and immediately publish a new blog (Admin)")
    public ResponseEntity<ApiResponse<BlogDto>> createAdminBlog(
            @Valid @RequestBody CreateBlogRequest request,
            @AuthenticationPrincipal UserPrincipal principal) {
        BlogDto blog = blogService.createAdminBlog(request, principal.getId());
        return new ResponseEntity<>(ApiResponse.success(blog, "Blog published successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/api/admin/blogs/pending")
    @Operation(summary = "List all blogs awaiting moderator approval (Admin)")
    public ResponseEntity<ApiResponse<Page<BlogDto>>> getPendingBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BlogDto> blogs = blogService.getPendingBlogs(pageable);
        return ResponseEntity.ok(ApiResponse.success(blogs, "Pending review blogs retrieved successfully"));
    }

    @PostMapping("/api/admin/blogs/{id}/approve")
    @Operation(summary = "Approve and publish a student blog (Admin)")
    public ResponseEntity<ApiResponse<BlogDto>> approveBlog(
            @PathVariable UUID id,
            @AuthenticationPrincipal UserPrincipal principal) {
        BlogDto blog = blogService.approveBlog(id, principal.getId());
        return ResponseEntity.ok(ApiResponse.success(blog, "Blog approved and published successfully"));
    }

    @PostMapping("/api/admin/blogs/{id}/reject")
    @Operation(summary = "Reject a student blog with review comments (Admin)")
    public ResponseEntity<ApiResponse<BlogDto>> rejectBlog(
            @PathVariable UUID id,
            @Valid @RequestBody RejectBlogRequest request,
            @AuthenticationPrincipal UserPrincipal principal) {
        BlogDto blog = blogService.rejectBlog(id, request, principal.getId());
        return ResponseEntity.ok(ApiResponse.success(blog, "Blog review rejected successfully"));
    }
}
