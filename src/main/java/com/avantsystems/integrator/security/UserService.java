package com.avantsystems.integrator.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    UserDao userDao;

    @Autowired
    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public User getUser(final String userName){
        return this.userDao.findUser(userName);
    }

}
