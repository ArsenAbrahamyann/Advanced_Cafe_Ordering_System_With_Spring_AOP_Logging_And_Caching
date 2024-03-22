package com.picsartacademy.dto;

import com.picsartacademy.entity.MenuItem;
import com.picsartacademy.entity.Order;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class OrderItemDTO {
    private Long id;
    private Order order;
    private MenuItem menuItem;
    private Long quantity;
    private Double priceAtTime;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Long id, Order order, MenuItem menuItem, Long quantity, Double priceAtTime) {
        this.id = id;
        this.order = order;
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.priceAtTime = priceAtTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getPriceAtTime() {
        return priceAtTime;
    }

    public void setPriceAtTime(Double priceAtTime) {
        this.priceAtTime = priceAtTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemDTO that = (OrderItemDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(order, that.order) && Objects.equals(menuItem, that.menuItem) && Objects.equals(quantity, that.quantity) && Objects.equals(priceAtTime, that.priceAtTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, menuItem, quantity, priceAtTime);
    }

    @Override
    public String toString() {
        return "OrderItemDTO{" +
               "id=" + id +
               ", order=" + order +
               ", menuItem=" + menuItem +
               ", quantity=" + quantity +
               ", priceAtTime=" + priceAtTime +
               '}';
    }
}
