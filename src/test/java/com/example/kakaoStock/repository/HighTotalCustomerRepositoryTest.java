package com.example.kakaoStock.repository;

import com.example.kakaoStock.model.HighTotalCustomerResult;
import com.example.kakaoStock.model.entity.HighTotalCustomer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.time.Year;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class HighTotalCustomerRepositoryTest {
    @Autowired
    private HighTotalCustomerRepository highTotalCustomerRepository;

    @Test
    void getHighTotalCustomer() {

        List<HighTotalCustomerResult> highTotalCustomers = highTotalCustomerRepository.getHighTotalCustomer();

        then(!highTotalCustomers.isEmpty());

        for(HighTotalCustomerResult vo : highTotalCustomers){
            then(vo.getYear()).isEqualTo(2018);
            then(vo.getName()).isEqualTo("테드");
            then(vo.getAcctNo()).isEqualTo("11111114");
            then(vo.getSumAmt()).isEqualTo(28992000);
        }
    }
}