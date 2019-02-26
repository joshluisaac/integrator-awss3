package com.avantsystems.integrator.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDao userDao;
    private RoleDao roleDao;


    public UserDetailsServiceImpl(UserDao userDao, RoleDao roleDao){
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) {
        Optional<User> maybeUser = Optional.ofNullable(userDao.findUser(userName));
        User user = maybeUser.orElse(new User(Long.valueOf(-888),"username","password"));
        List<String> roles = getUserRoles(user.getUserId());
        List<GrantedAuthority> userGrantedAuthorities = new ArrayList<>();

        for (String role : roles) {
            userGrantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getEncrytedPassword(),userGrantedAuthorities);
    }


    public List<String> getUserRoles(Long userId){
        return roleDao.getUserRoles(userId);
    }
}
