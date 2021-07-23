package com.example.kakaoStock.repository;

import com.example.kakaoStock.model.HighTotalCustomerResult;
import com.example.kakaoStock.model.NoTransactionResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class NoTransactionRepositoryTest {
    @Autowired
    private NoTransactionRepository noTransactionRepository;

    @Test
    void getNoTransaction() {
        List<NoTransactionResult> noTransactionResults = noTransactionRepository.getNoTransaction();

        then(!noTransactionResults.isEmpty());

        for(NoTransactionResult vo : noTransactionResults){
            then(vo.getYear()).isEqualTo(2018);
            then(vo.getName()).isEqualTo("테드");
            then(vo.getAcctNo()).isEqualTo("11111114");
        }
    }
}