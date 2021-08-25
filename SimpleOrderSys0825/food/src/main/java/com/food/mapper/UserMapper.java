package com.food.mapper;

import com.food.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 文淦
 * @version 1.0
 * 会员表映射Mapper
 */

@Mapper
public interface UserMapper {

    /**
     * 根据用户名、密码查询会员信息
     * @param username
     * @param password
     * @return
     */
    @Select("select * from user where username = #{username} and password = #{password}")
    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名查询会员信息
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    public User findByUsername(String username);

    /**
     * 添加会员信息
     * 用户名、密码以及会员等级
     * @param user
     */
    @Insert("insert into user(username,password,level) values(#{username},#{password},#{level})")
    public void insertUser(User user);


}
