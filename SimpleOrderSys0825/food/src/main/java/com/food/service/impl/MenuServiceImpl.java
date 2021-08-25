package com.food.service.impl;

import com.food.mapper.MenuMapper;
import com.food.domain.Menu;
import com.food.service.IMenuService;
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
public class MenuServiceImpl implements IMenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findByOrderId(int orderId) {
        return menuMapper.findByOrderId(orderId);
    }

    @Override
    public List<Menu> findByAll() {
        return menuMapper.findByAll();
    }

    @Override
    public void updateSupply(int id, int supply) {
        menuMapper.updateSupply(id,supply);
    }

    @Override
    public List<Menu> findById(String[] ids) {
        return menuMapper.findById(ids);
    }

    @Override
    public Menu findByName(String name) {
        return menuMapper.findByName(name);
    }

    @Override
    public Menu findByIdOne(int id) {
        return menuMapper.findByIdOne(id);
    }
}
