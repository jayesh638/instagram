package com.example.instagram.dao;

import com.example.instagram.entity.UserInfo;
import com.example.instagram.mapper.UserRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    public UserDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    NamedParameterJdbcTemplate template;

    @Override
    public void insertUser(UserInfo userInfo) {
        final String sql = "insert into users(id, username, password) values(:id, :username,:password)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", userInfo.getId())
                .addValue("username", userInfo.getUsername())
                .addValue("password", userInfo.getPassword());
        template.update(sql,param, holder);
    }

    @Override
    public List<UserInfo> findAll() {
        return template.query("select * from users;", new UserRowMapper());
    }


}
