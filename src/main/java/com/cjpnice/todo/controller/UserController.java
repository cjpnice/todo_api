package com.cjpnice.todo.controller;

import com.cjpnice.todo.entity.User;
import com.cjpnice.todo.service.UserService;
import com.cjpnice.todo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @author CHEN
 * @date 2022/4/24 16:02
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Result register(String userName, String password){
        List<User> registeredUser = userService.selectByUserName(userName);
        if(registeredUser.isEmpty()){
            String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
            User user = new User();
            user.setUserName(userName);
            user.setPassword(passwordMd5);
            if(userService.addUser(user)==1) {
                return Result.success(null,"注册成功");
            }else{
                return Result.error(null, "注册失败");
            }
        }else{
            return Result.error(null, "已存在该用户名");
        }

    }

    @PostMapping("/login")
    public Result login(String userName, String password){
        List<User> registeredUser = userService.selectByUserName(userName);
        if(registeredUser.isEmpty()){
            return Result.error(null, "不存在该用户");
        }else{
            String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
            if(registeredUser.get(0).getPassword().equals(passwordMd5)){
                return Result.success(registeredUser.get(0),"登陆成功");
            }else{
                return Result.error(null, "用户名密码错误");
            }
        }
    }

}
