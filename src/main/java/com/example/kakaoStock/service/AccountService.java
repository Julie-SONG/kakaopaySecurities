package com.example.kakaoStock.service;

import com.example.kakaoStock.model.AccountResult;
import com.example.kakaoStock.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<AccountResult> getAccountByBranchCode(String branchCode){
        List<AccountResult> aa = accountRepository.getAccount(branchCode);
        return aa;
    }
}