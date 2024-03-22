package com.picsartacademy.service.impl;

import com.picsartacademy.dao.BillDAO;
import com.picsartacademy.dto.BillDTO;
import com.picsartacademy.entity.Bill;
import com.picsartacademy.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillDAO billDAO;


    @Override
    @Transactional
    public BillDTO generateBill(Long orderId) {
        return billDAO.generateBill(orderId);
    }
}
