package com.example.instagram.service;

import com.example.instagram.entity.UserInfo;

import java.util.List;

public interface LoginService {


    void addUserData(UserInfo userInfo);

    List<UserInfo> getAllUsers();
}
