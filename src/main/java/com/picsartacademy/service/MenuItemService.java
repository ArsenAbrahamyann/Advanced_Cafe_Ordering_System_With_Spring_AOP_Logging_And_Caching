package com.picsartacademy.service;

import com.picsartacademy.dto.MenuItemDTO;
import com.picsartacademy.entity.MenuItem;

import java.util.List;

public interface MenuItemService {
    List<MenuItemDTO> getAllMenuItem();

    void updateMenuItem(Long id, MenuItemDTO menuItemDTO);

    void addMenuItem(MenuItemDTO menuItemDTO);

    void removeMenuItem(Long id);
}
