package com.picsartacademy.dto;

import com.picsartacademy.entity.OrderItem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

public class OrderDTO {
    private Long id;
    private Long waiterId;
    private Long tableNumber;
    private List<OrderItem> items;

    public OrderDTO() {
    }

    public OrderDTO(Long id, Long waiterId, Long tableNumber, List<OrderItem> items) {
        this.id = id;
        this.waiterId = waiterId;
        this.tableNumber = tableNumber;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(Long waiterId) {
        this.waiterId = waiterId;
    }

    public Long getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Long tableNumber) {
        this.tableNumber = tableNumber;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(id, orderDTO.id) && Objects.equals(waiterId, orderDTO.waiterId) && Objects.equals(tableNumber, orderDTO.tableNumber) && Objects.equals(items, orderDTO.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, waiterId, tableNumber, items);
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
               "id=" + id +
               ", waiterId=" + waiterId +
               ", tableNumber=" + tableNumber +
               ", items=" + items +
               '}';
    }
}
