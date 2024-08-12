package com.zosh.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.domain.VerificationType;
import com.zosh.model.ForgotPasswordToken;
import com.zosh.model.User;
import com.zosh.repository.ForgotPasswordRepository;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {
    @Autowired
    private ForgotPasswordRepository forgotPasswordRepository;

    @Override
    public ForgotPasswordToken createToken(User user, String id, String otp, VerificationType verificationType,
            String sendTo) {
        ForgotPasswordToken forgotPasswordToken = new ForgotPasswordToken();
        forgotPasswordToken.setUser(user);
        forgotPasswordToken.setSendTo(sendTo);
        forgotPasswordToken.setOtp(otp);
        forgotPasswordToken.setUser(user);
        forgotPasswordToken.setId(id);
        return forgotPasswordRepository.save(forgotPasswordToken);
    }

    @Override
    public ForgotPasswordToken findById(String id) {
        Optional<ForgotPasswordToken> token = forgotPasswordRepository.findById(id);
        return token.orElse(null);
    }

    @Override
    public ForgotPasswordToken findByUser(Long userId) {
        return forgotPasswordRepository.findByUserId(userId);
    }

    @Override
    public void deleteTOken(ForgotPasswordToken token) {
        forgotPasswordRepository.delete(token);
    }

}
