package com.picsartacademy.dao.impl;

import com.picsartacademy.dao.BillDAO;
import com.picsartacademy.dto.BillDTO;
import com.picsartacademy.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillDAOImpl implements BillDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public BillDTO generateBill(Long orderId) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, orderId);
        if (order == null) {
            return null;
        }
        double totalAmount = 0.0;
        for (OrderItem orderItem : order.getItems()) {
            MenuItem menuItem = orderItem.getMenuItem();
            totalAmount += menuItem.getPrice() * orderItem.getQuantity();
        }
        BillDTO bill = new BillDTO();
        bill.setTotalAmount(totalAmount);
        bill.setOrderId(orderId);

        return bill;
    }
}
