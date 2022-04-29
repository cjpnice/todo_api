package com.cjpnice.todo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjpnice.todo.entity.User;
import com.cjpnice.todo.mapper.UserMapper;
import com.cjpnice.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @author CHEN
 * @date 2022/4/24 16:00
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public List<User> selectByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }
}
