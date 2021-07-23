package com.example.kakaoStock.controller;

import com.example.kakaoStock.service.BranchTotalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@Api(tags = "BranchTotal")
@RestController

@RequestMapping("/kakaoStock/")
public class BranchTotalController {
    @Autowired
    private BranchTotalService branchTotalService;

    @ApiOperation(value = "branchTotal")
    @GetMapping(value = "/branchTotal")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBranchTotalInfo(String brName) {
        return branchTotalService.getBranchTotal(brName);
    }
}