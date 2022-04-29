package com.cjpnice.todo.service;

import com.cjpnice.todo.entity.User;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @author CHEN
 * @date 2022/4/24 15:59
 */
public interface UserService {
    int addUser(User user);
    List<User> selectByUserName(String userName);
}
