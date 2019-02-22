package com.avantsystems.integrator.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

    private String encodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    public static void main(String[] args) {
        System.out.println(new PasswordUtils().encodePassword("joshua"));
    }
}
