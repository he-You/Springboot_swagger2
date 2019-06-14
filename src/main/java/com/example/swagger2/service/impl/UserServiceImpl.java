package com.example.swagger2.service.impl;

import com.example.swagger2.dao.UserDao;
import com.example.swagger2.entity.User;
import com.example.swagger2.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by heyou on 2019/6/14 0014.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
