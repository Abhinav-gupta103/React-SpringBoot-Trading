package com.zosh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
