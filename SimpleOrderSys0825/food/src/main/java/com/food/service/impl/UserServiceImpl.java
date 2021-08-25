package com.food.service.impl;

import com.food.mapper.UserMapper;
import com.food.domain.User;
import com.food.service.IUserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 文淦
 * @version 1.0
 * 用户服务层接口实现类
 */

@Service
@Component
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userMapper.findByUsernameAndPassword(username,password);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
