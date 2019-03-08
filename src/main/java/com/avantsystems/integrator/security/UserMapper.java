package com.avantsystems.integrator.security;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

public class UserMapper {

    protected static final String GET_USER_QUERY = "select user_id, user_name, encryted_password from avant_user";

    //this throws an SQL exception but test it first
    RowMapper<User> mapEachRow = (ResultSet resultSet, int i) ->
            new User(resultSet.getLong("user_id"), resultSet.getString("user_name"), resultSet.getString("encryted_password"));
}
