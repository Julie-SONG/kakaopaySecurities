package com.example.kakaoStock.controller;

import com.example.kakaoStock.model.entity.Branch;
import com.example.kakaoStock.model.entity.BranchTotal;
import com.example.kakaoStock.service.BranchTotalService;
import com.example.kakaoStock.service.NoTransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BranchTotalController.class)
class BranchTotalControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BranchTotalService branchTotalService;

    @Test
    void getBranchTotalInfo() throws Exception {

        this.mvc.perform(get("/kakaoStock/branchTotal").param("brName","을지로점"))
                .andDo(print())
                //정상 처리 되는지 확인
                .andExpect(status().isOk());
    }
}