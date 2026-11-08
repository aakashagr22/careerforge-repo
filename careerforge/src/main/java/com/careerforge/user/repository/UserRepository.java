package com.careerforge.user.repository;

import com.careerforge.user.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    long countByRoleAndActiveTrue(com.careerforge.user.entity.Role role);

    @Query("""
            SELECT u FROM User u
            WHERE u.active = true
              AND u.id <> :currentUserId
              AND (LOWER(u.firstName) LIKE LOWER(CONCAT('%', :query, '%'))
                   OR LOWER(u.lastName) LIKE LOWER(CONCAT('%', :query, '%'))
                   OR LOWER(u.email) LIKE LOWER(CONCAT('%', :query, '%')))
            ORDER BY u.firstName ASC, u.lastName ASC
            """)
    List<User> searchActiveUsers(@Param("currentUserId") UUID currentUserId,
                                 @Param("query") String query,
                                 Pageable pageable);
}
