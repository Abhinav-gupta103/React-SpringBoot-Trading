package com.zosh.service;

import com.zosh.domain.VerificationType;
import com.zosh.model.User;

public interface UserService {
    public User findUserProfileByJwt(String jwt) throws Exception;

    public User findUserByEmail(String email) throws Exception;

    public User findUserById(Long userId) throws Exception;

    public User enableTwoFactorAuthentication(
            VerificationType verificationType, String sendTo, User user);

    public User updatePassword(User user, String newPassword);
}
