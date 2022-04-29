package com.cjpnice.todo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjpnice.todo.entity.TodoList;
import com.cjpnice.todo.mapper.TodoListMapper;
import com.cjpnice.todo.service.TodeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Intellij IDEA
 *
 * @author CHEN
 * @date 2022/4/24 20:56
 */
@Service
@Transactional
public class TodoListServiceImpl extends ServiceImpl<TodoListMapper, TodoList> implements TodeListService {
    @Autowired
    TodoListMapper todoListMapper;

    @Override
    public int addTodoList(TodoList todoList) {
        return todoListMapper.addTodoList(todoList);
    }

    @Override
    public List<TodoList> selectAllTodoList(String userName) {
        return todoListMapper.selectAllTodoList(userName);
    }

    @Override
    public List<TodoList> selectFinishedTodoList(String userName) {
        return todoListMapper.selectFinishedTodoList(userName);
    }

    @Override
    public List<TodoList> selectUnfinishedTodoList(String userName) {
        return todoListMapper.selectUnfinishedTodoList(userName);
    }

    @Override
    public int updateById(int isFinished, int id) {
        return todoListMapper.updateById(isFinished,id);
    }
}
