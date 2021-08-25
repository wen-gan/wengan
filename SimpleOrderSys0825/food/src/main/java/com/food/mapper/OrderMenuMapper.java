package com.food.mapper;

import com.food.domain.OrderMenu;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 * 订单内容表映射Mapper
 */

@Mapper
public interface OrderMenuMapper {

    //添加订单内的订单id，菜品id，以及菜品的数量
    @Insert({"<script>" +
            "insert into order_menu values" +
                "<foreach collection='list' item='item' separator=','>" +
                    "(#{item.orderId},#{item.menuId},#{item.amount})" +
                "</foreach>" +
            "</script>"})
    public void insertOrderMenu(List<OrderMenu> orderMenuList);

    //查找订单菜单表的内容，通过订单id来进行查找
    @Select("select * from order_menu where orderId = #{orderId}")
    public List<OrderMenu> findByOrderId(int orderId);

    //可以对订单菜单表的内容按照订单id进行删除
    @Delete("delete from order_menu where orderId = #{orderId}")
    public void deleteByOrderId(int orderId);

}
