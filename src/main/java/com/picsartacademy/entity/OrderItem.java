package com.picsartacademy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "order_details")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private MenuItem menuItem;

    @NotNull
    @Column(name = "quantity")
    private Long quantity;

    @NotNull
    @Column(name = "price_at_time")
    private Double priceAtTime;

    public OrderItem() {
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
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id) && Objects.equals(order, orderItem.order) && Objects.equals(menuItem, orderItem.menuItem) && Objects.equals(quantity, orderItem.quantity) && Objects.equals(priceAtTime, orderItem.priceAtTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, menuItem, quantity, priceAtTime);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
               "id=" + id +
               ", order=" + order +
               ", menuItem=" + menuItem +
               ", quantity=" + quantity +
               ", priceAtTime=" + priceAtTime +
               '}';
    }
}
