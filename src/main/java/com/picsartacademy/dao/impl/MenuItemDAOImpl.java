package com.picsartacademy.dao.impl;

import com.picsartacademy.dao.MenuItemDAO;
import com.picsartacademy.dto.MenuItemDTO;
import com.picsartacademy.entity.Bill;
import com.picsartacademy.entity.MenuItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MenuItemDAOImpl implements MenuItemDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<MenuItemDTO> getAllMenuItem() {
        Session session = sessionFactory.getCurrentSession();
        List<MenuItem> allMenuItems = session.createQuery("from MenuItem", MenuItem.class).getResultList();
        List<MenuItemDTO> allMenuItemsDTO = allMenuItems.stream()
                .map(menuItem -> new MenuItemDTO(menuItem.getId(), menuItem.getName(), menuItem.getDescription(), menuItem.getPrice(), menuItem.getCategory()))
                .collect(Collectors.toList());
        return allMenuItemsDTO;
    }


    @Override
    public void updateMenuItem(Long id, MenuItemDTO menuItemDTO) {
        Session session = sessionFactory.getCurrentSession();
        MenuItem menuItem = session.get(MenuItem.class, id);
        if (menuItem != null) {
            menuItem.setCategory(menuItemDTO.getCategory());
            menuItem.setDescription(menuItemDTO.getDescription());
            menuItem.setName(menuItemDTO.getName());
            menuItem.setPrice(menuItemDTO.getPrice());
            session.merge(menuItem);
        }
    }


    @Override
    public void addMenuItem(MenuItemDTO menuItemDTO) {
        Session session = sessionFactory.getCurrentSession();
        MenuItem menuItem = new MenuItem(
                menuItemDTO.getId(),
                menuItemDTO.getName(),
                menuItemDTO.getDescription(),
                menuItemDTO.getPrice(),
                menuItemDTO.getCategory()
        );
        session.persist(menuItem);
    }


    @Override
    public void removeMenuItem(Long id) {
        Session session = sessionFactory.getCurrentSession();
        MenuItem menuItem = session.get(MenuItem.class, id);
        if (menuItem != null) {
            session.delete(menuItem);
        }
    }
}
