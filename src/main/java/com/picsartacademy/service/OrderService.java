package com.picsartacademy.service;

import com.picsartacademy.dto.OrderDTO;
import com.picsartacademy.dto.OrderItemDTO;
import com.picsartacademy.entity.Order;
import com.picsartacademy.entity.OrderItem;

import java.util.List;

public interface OrderService {

    Long placeOrder(OrderDTO order);

    OrderDTO viewOrder(Long id);

    void cancelOrder(Long id);

    OrderDTO modifyOrder(Long id, List<OrderItemDTO> items);

    List<OrderDTO> viewPastOrders(String startDate, String endDate);
}
