package com.food.service;

import com.food.domain.User;

/**
 * @author 文淦
 * @version 1.0
 * 用户服务层接口
 */

public interface IUserService {

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

    void insertUser(User user);

}
