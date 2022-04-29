package com.cjpnice.todo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created by Intellij IDEA
 *
 * @author CHEN
 * @date 2022/4/24 15:53
 */

@Data
@TableName("user")
public class User {
    Integer id;
    String userName;
    String password;
}
