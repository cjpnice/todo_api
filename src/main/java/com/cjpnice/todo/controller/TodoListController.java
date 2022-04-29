package com.cjpnice.todo.controller;

import com.cjpnice.todo.entity.TodoList;
import com.cjpnice.todo.entity.User;
import com.cjpnice.todo.service.TodeListService;
import com.cjpnice.todo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @author CHEN
 * @date 2022/4/24 20:57
 */
@RestController
@RequestMapping("/todoList")
public class TodoListController {
    @Autowired
    TodeListService todeListService;

    @PostMapping("/addTodoList")
    public Result addTodoList(String userName, String content){
        TodoList todoList = new TodoList();
        Date time = new Date(System.currentTimeMillis());
        todoList.setContent(content);
        todoList.setTime(time);
        todoList.setIsFinished(0);
        todoList.setUserName(userName);
        if(todeListService.addTodoList(todoList)==1){
            return Result.success(null,"添加成功");
        }else{
            return Result.error(null, "添加失败");
        }
    }

    @PostMapping("/selectAllTodoList")
    public Result selectAllTodoList(String userName){
        List<TodoList> todoList = todeListService.selectAllTodoList(userName);
        return Result.success(todoList,"查询成功");
    }

    @PostMapping("/selectFinishedTodoList")
    public Result selectFinishedTodoList(String userName){
        List<TodoList> todoList = todeListService.selectFinishedTodoList(userName);
        return Result.success(todoList,"查询成功");
    }

    @PostMapping("/selectUnfinishedTodoList")
    public Result selectUnfinishedTodoList(String userName){
        List<TodoList> todoList = todeListService.selectUnfinishedTodoList(userName);
        return Result.success(todoList,"查询成功");
    }
    @PostMapping("/updateTodoList")
    public Result updateTodoList(int id, int isFinished){
        if(todeListService.updateById(isFinished,id)==1){
            return Result.success(null,"更新成功");
        }
        return Result.error(null,"更新失败");
    }
}
