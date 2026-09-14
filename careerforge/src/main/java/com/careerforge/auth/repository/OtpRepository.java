package com.careerforge.auth.repository;

import com.careerforge.auth.entity.Otp;
import com.careerforge.auth.entity.OtpType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OtpRepository extends JpaRepository<Otp, UUID> {

    Optional<Otp> findTopByEmailAndOtpTypeAndVerifiedFalseOrderByCreatedAtDesc(String email, OtpType otpType);

    void deleteAllByEmailAndOtpType(String email, OtpType otpType);
}
