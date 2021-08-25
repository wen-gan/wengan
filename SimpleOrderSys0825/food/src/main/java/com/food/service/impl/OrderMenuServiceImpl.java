package com.food.service.impl;

import com.food.mapper.OrderMenuMapper;
import com.food.domain.OrderMenu;
import com.food.service.IOrderMenuService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 */

@Service
@Component
public class OrderMenuServiceImpl implements IOrderMenuService {

    @Resource
    private OrderMenuMapper orderMenuMapper;

    @Override
    public List<OrderMenu> findByOrderId(int orderId) {
        return orderMenuMapper.findByOrderId(orderId);
    }

    @Override
    public void insertOrderMenu(List<OrderMenu> orderMenuList) {
        orderMenuMapper.insertOrderMenu(orderMenuList);
    }

    @Override
    public void deleteByOrderId(int orderId) {
        orderMenuMapper.deleteByOrderId(orderId);
    }
}
