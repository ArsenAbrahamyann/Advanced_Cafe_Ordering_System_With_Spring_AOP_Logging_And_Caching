package com.picsartacademy.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class BillDTO {
    private Long id;
    private Long orderId;
    private double totalAmount;

    public BillDTO() {
    }

    public BillDTO(Long id, Long orderId, double totalAmount) {
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
        BillDTO billDTO = (BillDTO) o;
        return Double.compare(totalAmount, billDTO.totalAmount) == 0 && Objects.equals(id, billDTO.id) && Objects.equals(orderId, billDTO.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, totalAmount);
    }

    @Override
    public String toString() {
        return "BillDTO{" +
               "id=" + id +
               ", orderId=" + orderId +
               ", totalAmount=" + totalAmount +
               '}';
    }
}
