package com.zosh.service;

import com.zosh.model.TwoFactorOTP;
import com.zosh.model.User;

public interface TwoFactorOtpService {
    TwoFactorOTP createTwoFactorOTP(User user, String otp, String jwt);

    TwoFactorOTP findByUser(Long userId);

    TwoFactorOTP findById(String id);

    boolean verifyTwoFactorOtp(TwoFactorOTP twoFactorOTP, String otp);

    void deleteTwoFactorOtp(TwoFactorOTP twoFactorOTP);

}
