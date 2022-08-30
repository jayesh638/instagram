package com.example.instagram.service;

import com.example.instagram.dao.UserDao;
import com.example.instagram.entity.UserInfo;
import com.example.instagram.util.InstaFunctions;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.List;

@Component
public class LoginServiceImpl implements LoginService {

    @Resource
    UserDao userDao;

    @Resource
    InstaFunctions f;

    @Override
    public void addUserData(UserInfo userInfo) {
        UserInfo req = new UserInfo();
        req.setId(f.getUniqueId());
        req.setUsername(userInfo.getUsername());
        req.setPassword(userInfo.getPassword());
        userDao.insertUser(req);
    }

    @Override
    public List<UserInfo> getAllUsers() {
        return userDao.findAll();
    }
}
