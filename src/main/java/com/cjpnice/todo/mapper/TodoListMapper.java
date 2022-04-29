package com.cjpnice.todo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjpnice.todo.entity.TodoList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @author CHEN
 * @date 2022/4/24 20:55
 */
@Repository
public interface TodoListMapper extends BaseMapper<TodoList> {
    @Insert("insert into todo_list (user_name, is_finished, time, content) values (#{userName},#{isFinished}, #{time}, #{content});")
    int addTodoList(TodoList todoList);

    @Select("select * from todo_list where user_name=#{userName}")
    List<TodoList> selectAllTodoList(String userName);

    @Select("select * from todo_list where user_name=#{userName} and is_finished=1")
    List<TodoList> selectFinishedTodoList(String userName);

    @Select("select * from todo_list where user_name=#{userName} and is_finished=0")
    List<TodoList> selectUnfinishedTodoList(String userName);

    @Update("update todo_list set is_finished=#{isFinished} where id=#{id}")
    int updateById(@Param("isFinished")int isFinished,@Param("id")int id);
}
