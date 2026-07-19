package com.careerforge.blog.repository;

import com.careerforge.blog.entity.Blog;
import com.careerforge.blog.entity.BlogStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BlogRepository extends JpaRepository<Blog, UUID> {
    Page<Blog> findByStatusOrderByCreatedAtDesc(BlogStatus status, Pageable pageable);
    
    Page<Blog> findByStatusOrderByCreatedAtAsc(BlogStatus status, Pageable pageable);

    Page<Blog> findByAuthorIdOrderByCreatedAtDesc(UUID authorId, Pageable pageable);
}
