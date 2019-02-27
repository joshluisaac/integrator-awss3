package com.avantsystems.integrator.security;

public interface UserService {

    User findUserById();
    User findUserByEmail(final String email);
    void save();
    void delete(User user);
    void update(User user);


}
