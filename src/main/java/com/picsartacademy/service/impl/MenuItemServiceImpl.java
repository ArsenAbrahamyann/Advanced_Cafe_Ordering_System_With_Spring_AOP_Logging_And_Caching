package com.picsartacademy.service.impl;

import com.picsartacademy.dao.MenuItemDAO;
import com.picsartacademy.dto.MenuItemDTO;
import com.picsartacademy.entity.MenuItem;
import com.picsartacademy.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemDAO menuItemDAO;

    @Override
    @Transactional
    public List<MenuItemDTO> getAllMenuItem() {
        return menuItemDAO.getAllMenuItem();
    }

    @Override
    @Transactional
    public void updateMenuItem(Long id, MenuItemDTO menuItem) {
        menuItemDAO.updateMenuItem(id,menuItem);
    }

    @Override
    @Transactional
    public void addMenuItem(MenuItemDTO menuItem) {
        menuItemDAO.addMenuItem(menuItem);
    }


    @Override
    @Transactional
    public void removeMenuItem(Long id) {
        menuItemDAO.removeMenuItem(id);
    }
}
