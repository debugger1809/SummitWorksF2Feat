package com.group6.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group6.pro.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
