package com.example.kakaoStock.controller;

import com.example.kakaoStock.service.HighTotalCustomerService;
import com.example.kakaoStock.service.NoTransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NoTransactionController.class)
class NoTransactionControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private NoTransactionService noTransactionService;

    @Test
    void getNoTransactionInfo() throws Exception {
        ResultActions actions = mvc.perform((get("/kakaoStock/noTransaction")))
                .andDo(print());

        actions.andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andDo(print());
    }
}