package com.example.kakaoStock.controller;

import com.example.kakaoStock.service.TotalByYearBranchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags = "TotalByYearBranch")
@RestController

@RequestMapping("/kakaoStock/")
public class TotalByYearBranchController {
    @Autowired
    private TotalByYearBranchService totalByYearBranchService;

    @ApiOperation(value = "totalByYearBranch")
    @GetMapping(value = "/totalByYearBranch")
    public List<Map<String, Object>> getTotalByYearBranchInfo() {
        return totalByYearBranchService.getTotalByYearBranch();
    }
}