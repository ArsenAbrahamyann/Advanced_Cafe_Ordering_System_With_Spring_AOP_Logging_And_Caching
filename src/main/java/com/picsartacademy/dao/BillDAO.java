package com.picsartacademy.dao;

import com.picsartacademy.dto.BillDTO;

public interface BillDAO {
    BillDTO generateBill(Long orderId);
}
