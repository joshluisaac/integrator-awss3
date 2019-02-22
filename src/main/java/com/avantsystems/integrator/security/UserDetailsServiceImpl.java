package com.avantsystems.integrator.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sun.plugin2.message.Message;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDao userDao;

    public UserDetailsServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //getLoginUser
        User user =  userDao.findUser(userName);
        //getUserRoles

        if (user == null) {
            throw new UsernameNotFoundException(MessageFormat.format("User name {0} is not found",userName));
        }

        List<String> roles = new ArrayList<>(Arrays.asList("ROLE_ADMIN","ROLE_USER"));

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        for (String role : roles) {
            GrantedAuthority authority = new SimpleGrantedAuthority(role);
            grantList.add(authority);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getEncrytedPassword(),grantList);
    }
}
