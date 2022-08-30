package com.example.instagram.mapper;

import com.example.instagram.entity.UserInfo;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserInfo> {

    @Override
    public UserInfo mapRow(ResultSet rs, int args1) throws SQLException{
        UserInfo userInfo = new UserInfo();
        userInfo.setId(rs.getString("id"));
        userInfo.setUsername(rs.getString("username"));
        userInfo.setPassword(rs.getString("password"));
        return  userInfo;
    }

}
