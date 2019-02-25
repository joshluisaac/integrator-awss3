package com.avantsystems.integrator.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Repository
@Transactional(readOnly = true)
public class UserDao extends JdbcDaoSupport {

    public static final Logger LOG = LoggerFactory.getLogger(UserDao.class);

    public UserDao(DataSource dataSource){
        super.setDataSource(dataSource);
    }


    public User findUser(final String userName){
        final String getUserQuery = UserMapper.GET_USER_QUERY.concat(" where user_name = ?");
        UserMapper userMapper = new UserMapper();
        try{
            return this.getJdbcTemplate().queryForObject(getUserQuery, new Object[]{userName}, userMapper.mapEachRow);
        } catch(EmptyResultDataAccessException e){
            LOG.error("User does not exists");
            return null;
        }



    }


}
