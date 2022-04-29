package com.cjpnice.todo.service;

import com.cjpnice.todo.entity.TodoList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @author CHEN
 * @date 2022/4/24 20:56
 */
public interface TodeListService {
    int addTodoList(TodoList todoList);
    List<TodoList> selectAllTodoList(String userName);
    List<TodoList> selectFinishedTodoList(String userName);
    List<TodoList> selectUnfinishedTodoList(String userName);
    int updateById(int isFinished, int id);
}
