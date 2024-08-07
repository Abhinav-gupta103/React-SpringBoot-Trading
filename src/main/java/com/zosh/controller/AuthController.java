package com.zosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.model.User;
import com.zosh.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody User user) throws Exception {
        User isEmailExist = userRepository.findByEmail(user.getEmail());

        if (isEmailExist != null) {
            throw new Exception("email is already used with another account");
        }

        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setFullName(user.getFullName());

        Authentication auth = new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                user.getPassword());

        SecurityContextHolder.getContext().setAuthentication(auth);

        User savedUser = userRepository.save(newUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
