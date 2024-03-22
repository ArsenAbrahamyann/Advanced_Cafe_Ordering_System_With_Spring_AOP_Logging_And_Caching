package com.picsartacademy.dao;

import com.picsartacademy.dto.MenuItemDTO;
import com.picsartacademy.entity.MenuItem;

import java.util.List;

public interface MenuItemDAO {
    public List<MenuItemDTO> getAllMenuItem();
    public void updateMenuItem(Long id,MenuItemDTO menuItem);
    public void addMenuItem(MenuItemDTO menuItem);
    public void removeMenuItem(Long id);
}
