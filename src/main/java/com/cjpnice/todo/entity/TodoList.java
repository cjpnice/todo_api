package com.cjpnice.todo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

/**
 * Created by Intellij IDEA
 *
 * @author CHEN
 * @date 2022/4/24 15:54
 */
@Data
@TableName("todo_list")
public class TodoList {
    Integer id;
    String userName;
    Integer isFinished;
    Date time;
    String content;


}
