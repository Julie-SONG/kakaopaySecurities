package com.example.kakaoStock.controller;

import com.example.kakaoStock.model.HighTotalCustomerResult;
import com.example.kakaoStock.service.HighTotalCustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "HighTotal")
@RestController

@RequestMapping("/kakaoStock/")
public class HighTotalCustomerController {
    @Autowired
    private HighTotalCustomerService highTotalCustomerService;

    @ApiOperation(value = "highTotalCustomer")
    @GetMapping(value = "/highTotalCustomer")
    public List<HighTotalCustomerResult> getHighTotalCustomerInfo() {
        return highTotalCustomerService.getHighTotalCustomer();
    }
}