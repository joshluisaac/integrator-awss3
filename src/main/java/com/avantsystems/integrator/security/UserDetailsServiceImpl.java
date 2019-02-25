package com.avantsystems.integrator.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    UserDao userDao;
    RoleDao roleDao;


    public UserDetailsServiceImpl(UserDao userDao, RoleDao roleDao){
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> maybeUser = Optional.ofNullable(userDao.findUser(userName));
        User user = maybeUser.orElse(new User(new Long(-888),"username","password"));
        List<String> roles = getRoles();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

        for (String role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getEncrytedPassword(),grantedAuthorities);
    }


    public List<String> getRoles(){
        return new ArrayList<>(Arrays.asList("ROLE_ADMIN","ROLE_USER"));
    }
}
