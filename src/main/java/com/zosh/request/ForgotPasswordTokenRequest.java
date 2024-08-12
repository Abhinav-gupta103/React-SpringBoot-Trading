package com.zosh.request;

import com.zosh.domain.VerificationType;

import lombok.Data;

@Data
public class ForgotPasswordTokenRequest {
    private String sendTo;
    private VerificationType verificationType;
}
