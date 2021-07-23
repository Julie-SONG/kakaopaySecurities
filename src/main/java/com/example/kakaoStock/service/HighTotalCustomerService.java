package com.example.kakaoStock.service;

import com.example.kakaoStock.model.HighTotalCustomerResult;
import com.example.kakaoStock.repository.HighTotalCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HighTotalCustomerService {

    @Autowired
    private HighTotalCustomerRepository highTotalCustomerRepository;

    public List<HighTotalCustomerResult> getHighTotalCustomer(){
        List<HighTotalCustomerResult> results = highTotalCustomerRepository.getHighTotalCustomer();
        return results;
    }
}