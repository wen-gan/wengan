package com.food.mapper;

import com.food.domain.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 * 菜单表映射Mapper
 */

@Mapper
public interface MenuMapper {

    //通过订单id来查找菜单里的菜品信息
    //order_menu表里的menuId对应于menu表里的id
    //可以通过菜品id查询相应的菜品信息
    @Select("select * from order_menu,menu where order_menu.menuId = menu.id and order_menu.orderId=#{orderId}")
    public List<Menu> findByOrderId(int orderId);

    //直接查找菜单里的菜品信息
    @Select("select * from menu")
    public List<Menu> findByAll();

    //通过id查找数据
    @Select("<script>" +
            "select * from menu " +
                "<where>" +
                    "<foreach collection='array' open='id in(' close=')' item='id' separator=','>" +
                    " #{id}" +
                    "</foreach> ;"+
                "</where>" +
            "</script>")
    public List<Menu> findById(String[] ids);

    //可以对菜品的供应量进行修改
    @Update("update menu set supply = #{supply} where id = #{id}")
    public void updateSupply(@Param("id") int id, @Param("supply") int supply);

    //通过id查询相应的菜单里的菜品信息
    @Select("select * from menu where id = #{id}")
    public Menu findByIdOne(int id);

    //通过菜品名查询菜单里的菜品信息
    @Select("select * from menu where name = #{name}")
    public Menu findByName(String name);

}
