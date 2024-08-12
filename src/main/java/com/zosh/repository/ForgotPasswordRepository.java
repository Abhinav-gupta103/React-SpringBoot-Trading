package com.zosh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.model.ForgotPasswordToken;

public interface ForgotPasswordRepository extends JpaRepository<ForgotPasswordToken, String> {
    ForgotPasswordToken findByUserId(Long userId);

}
