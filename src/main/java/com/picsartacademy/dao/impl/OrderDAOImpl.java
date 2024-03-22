package com.picsartacademy.dao.impl;

import com.picsartacademy.dao.OrderDAO;
import com.picsartacademy.dto.OrderDTO;
import com.picsartacademy.dto.OrderItemDTO;
import com.picsartacademy.entity.Order;
import com.picsartacademy.entity.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long placeOrder(OrderDTO order) {
        Session session = sessionFactory.getCurrentSession();
        Order order1 = new Order();
        order1.setId(order.getId());
        order1.setItems(order.getItems());
        order1.setTableNumber(order.getTableNumber());
        order1.setWaiterId(order.getWaiterId());
        session.persist(order1);
        return (Long) session.getIdentifier(order1);
    }

    @Override
    public OrderDTO viewOrder(Long id) {
        Session session = sessionFactory.getCurrentSession();
        OrderDTO orderDTO = new OrderDTO();
        Order order = session.get(Order.class, id);
        orderDTO.setItems(order.getItems());
        orderDTO.setId(order.getId());
        orderDTO.setTableNumber(order.getTableNumber());
        orderDTO.setWaiterId(order.getWaiterId());
        return orderDTO;
    }

    @Override
    public void cancelOrder(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, id);
        if (order != null) {
            session.delete(order);
        }
    }


    @Override
    public OrderDTO modifyOrder(Long id, List<OrderItemDTO> items) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, id);
        if (order == null) {
            return null;
        }
        for (OrderItemDTO itemDTO : items) {
            for (OrderItem orderItem : order.getItems()) {
                if (orderItem.getId().equals(itemDTO.getId())) {
                    orderItem.setQuantity(itemDTO.getQuantity());
                    break;
                }
            }
        }
        session.update(order);
        return viewOrder(id);
    }


    @Override
    public List<OrderDTO> viewPastOrders(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (startDate == null || startDate.isEmpty() || endDate == null || endDate.isEmpty()) {
            throw new IllegalArgumentException("Both startDate and endDate parameters are required.");
        }

        try {
            LocalDate parsedStartDate = LocalDate.parse(startDate, formatter);
            LocalDate parsedEndDate = LocalDate.parse(endDate, formatter);

            Session session = sessionFactory.getCurrentSession();
            Query<Order> query = session.createQuery("from Order where orderDate between :startDate and :endDate", Order.class);
            query.setParameter("startDate", parsedStartDate);
            query.setParameter("endDate", parsedEndDate);
            List<Order> orders = query.getResultList();
            List<OrderDTO> orderDTOList = new ArrayList<>();
            for (Order order : orders) {
                orderDTOList.add(viewOrder(order.getId()));
            }
            return orderDTOList;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Date format must be yyyy-MM-dd.");
        }
    }

}


