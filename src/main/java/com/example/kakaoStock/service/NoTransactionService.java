package com.example.kakaoStock.service;

import com.example.kakaoStock.model.NoTransactionResult;
import com.example.kakaoStock.repository.NoTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoTransactionService {

    @Autowired
    private NoTransactionRepository noTransactionRepository;

    public List<NoTransactionResult> getNoTransaction(){
        List<NoTransactionResult> results = noTransactionRepository.getNoTransaction();
        return results;
    }
}