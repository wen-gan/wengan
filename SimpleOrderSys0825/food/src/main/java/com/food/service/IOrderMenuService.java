package com.food.service;

import com.food.domain.OrderMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 */

public interface IOrderMenuService {

    void insertOrderMenu(List<OrderMenu> orderMenuList);

    List<OrderMenu> findByOrderId(int orderId);

    void deleteByOrderId(int orderId);

}
