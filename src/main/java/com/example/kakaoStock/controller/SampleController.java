package com.example.kakaoStock.controller;

import com.example.kakaoStock.model.AccountResult;
import com.example.kakaoStock.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Sample")
@RestController
//@RequestMapping("/test/")
@RequestMapping("/kakaoStock/")
public class SampleController {
    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "sample")
    @GetMapping(value = "/account")
    public List<AccountResult> getAccountInfo(String branchCode) {
        return accountService.getAccountByBranchCode(branchCode);
    }
}