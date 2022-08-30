package com.example.instagram.dao;

import com.example.instagram.entity.UserInfo;

import java.util.List;

public interface UserDao {

    void insertUser(UserInfo userInfo);

    List<UserInfo> findAll();
}
