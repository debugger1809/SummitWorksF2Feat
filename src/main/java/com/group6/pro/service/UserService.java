package com.group6.pro.service;

import com.group6.pro.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
