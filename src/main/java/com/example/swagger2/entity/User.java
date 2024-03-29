package com.example.swagger2.entity;

import lombok.Data;

/**
 * Created by heyou on 2019/6/14 0014.
 */
@Data
public class User {
    private Integer userId;
    private String username;
    private String password;
    public User(Integer userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

}
