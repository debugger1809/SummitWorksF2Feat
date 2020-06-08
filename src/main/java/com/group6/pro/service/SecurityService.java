package com.group6.pro.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
