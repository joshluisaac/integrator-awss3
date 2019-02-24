package com.avantsystems.integrator.security;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper  {

    protected static final String GET_USER_QUERY = "select user_id, user_name, encryted_password from avant_user";

    //this throws an SQL exception but test it first
    RowMapper<User> mapEachRow =  (ResultSet resultSet, int i) -> {
        Long userId = resultSet.getLong("user_id");
        String  userName = resultSet.getString("user_name");
        String encryptedPassword = resultSet.getString("encryted_password");

        return new User(userId,userName, encryptedPassword);
    };
}
