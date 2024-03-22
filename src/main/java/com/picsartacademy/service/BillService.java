package com.picsartacademy.service;

import com.picsartacademy.dto.BillDTO;

public interface BillService {
    BillDTO generateBill(Long orderId);
}
