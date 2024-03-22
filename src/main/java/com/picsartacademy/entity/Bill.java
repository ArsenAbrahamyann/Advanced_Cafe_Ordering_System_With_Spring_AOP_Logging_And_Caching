package com.picsartacademy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long id;

    @NotNull
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "totalAmount")
    private double totalAmount;

    public Bill() {
    }

    public Bill(Long id, Long orderId, double totalAmount) {
        this.id = id;
        this.orderId = orderId;
        this.totalAmount = totalAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Double.compare(totalAmount, bill.totalAmount) == 0 && Objects.equals(id, bill.id) && Objects.equals(orderId, bill.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, totalAmount);
    }

    @Override
    public String toString() {
        return "Bill{" +
               "id=" + id +
               ", orderId=" + orderId +
               ", totalAmount=" + totalAmount +
               '}';
    }
}
