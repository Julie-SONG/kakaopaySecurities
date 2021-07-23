package com.example.kakaoStock.controller;

import com.example.kakaoStock.model.NoTransactionResult;
import com.example.kakaoStock.service.NoTransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "NoTransaction")
@RestController
//@RequestMapping("/test/")
@RequestMapping("/kakaoStock/")
public class NoTransactionController {
    @Autowired
    private NoTransactionService noTransactionService;

    @ApiOperation(value = "noTransaction")
    @GetMapping(value = "/noTransaction")
    public List<NoTransactionResult> getNoTransactionInfo() { return noTransactionService.getNoTransaction();
    }
}