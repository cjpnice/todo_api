package com.cjpnice.todo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjpnice.todo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @author CHEN
 * @date 2022/4/24 15:58
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    @Insert("insert into user (user_name, password) values (#{userName},#{password});")
    int addUser(User user);

    @Select("select * from user where user_name=#{userName};")
    List<User> selectByUserName(String userName);


}
