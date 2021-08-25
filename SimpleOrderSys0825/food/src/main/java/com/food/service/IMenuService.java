package com.food.service;

import com.food.domain.Menu;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 */

public interface IMenuService {

    List<Menu> findByOrderId(int orderId);

    List<Menu> findByAll();

    List<Menu> findById(String[] ids);

    void updateSupply(int id, int supply);

    Menu findByIdOne(int id);

    Menu findByName(String name);

}
