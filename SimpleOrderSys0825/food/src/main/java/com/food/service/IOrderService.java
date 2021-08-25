package com.food.service;

import com.food.domain.Order;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 */

public interface IOrderService {

    List<Order> findAll();

    void insertOrder(Order order);

    List<Order> findAllToQueue();

    Order findById(int id);

    void updateOrder(Order order);

}
