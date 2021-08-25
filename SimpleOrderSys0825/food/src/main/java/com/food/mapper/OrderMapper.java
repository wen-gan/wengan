package com.food.mapper;

import com.food.domain.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 * 订单表映射Mapper
 */

@Mapper
public interface OrderMapper {

    //按照订单时间来排列查询订单信息
    @Select("select * from orders order by createTime desc")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "queue", property = "queue"),
            @Result(column = "createTime", property = "createTime"),
            @Result(column = "statue", property = "statue"),
            @Result(column = "completionTime", property = "completionTime"),
            @Result(column = "totalMoney", property = "totalMoney"),
            @Result(column = "discount", property = "discount"),
            @Result(column = "trueMoney", property = "trueMoney"),
            @Result(column = "userId", property = "userId"),
            @Result(
                    property = "menus",
                    column = "id",
                    javaType =List.class,
                    many =@Many(select = "com.food.mapper.MenuMapper.findByOrderId")
            )
    })
    public List<Order> findAll();

    //按照排队顺序来排列查询订单信息
    //column 代表MySQL数据库里面的列名，property 代表类中的属性名，二者之间产生映射关系
    @Select("select * from orders order by queue asc")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "queue", property = "queue"),
            @Result(column = "createTime", property = "createTime"),
            @Result(column = "statue", property = "statue"),
            @Result(column = "completionTime", property = "completionTime"),
            @Result(column = "totalMoney", property = "totalMoney"),
            @Result(column = "discount", property = "discount"),
            @Result(column = "trueMoney", property = "trueMoney"),
            @Result(column = "userId", property = "userId"),
            @Result(
                    property = "menus",
                    column = "id",
                    javaType =List.class,
                    many =@Many(select = "com.food.mapper.MenuMapper.findByOrderId")
            )
    })
    public List<Order> findAllToQueue();

    //按照订单id来查询订单信息
    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "queue", property = "queue"),
            @Result(column = "createTime", property = "createTime"),
            @Result(column = "statue", property = "statue"),
            @Result(column = "completionTime", property = "completionTime"),
            @Result(column = "totalMoney", property = "totalMoney"),
            @Result(column = "discount", property = "discount"),
            @Result(column = "trueMoney", property = "trueMoney"),
            @Result(column = "userId", property = "userId"),
            @Result(
                    property = "menus",
                    column = "id",
                    javaType =List.class,
                    many =@Many(select = "com.food.mapper.MenuMapper.findByOrderId")
            )
    })
    public Order findById(int id);

    //添加订单信息
    @Insert("insert into orders(queue,createTime,statue,completionTime,totalMoney,discount,trueMoney,userId) " +
            "values(#{queue},#{createTime},#{statue},#{completionTime},#{totalMoney},#{discount},#{trueMoney},#{userId})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")//id自增长
    public void insertOrder(Order order);

    //可以对订单信息进行修改（订单状态，订单完成时间，应付款，实付款）
    @Update("update orders set statue = #{statue}, completionTime = #{completionTime}, totalMoney = #{totalMoney}, trueMoney = #{trueMoney} where id = #{id}")
    public void updateOrder(Order order);

}
