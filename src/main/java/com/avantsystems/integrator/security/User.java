package com.avantsystems.integrator.security;



/**
 * A class that represents a single record/row in avant_user
 */

public class User {
    private Long userId;
    private String userName;
    private String encrytedPassword;

    public User(){}

    public User(Long userId, String userName, String encrytedPassword) {
        this.userId = userId;
        this.userName = userName;
        this.encrytedPassword = encrytedPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", encrytedPassword='" + encrytedPassword + '\'' +
                '}';
    }
}
