package com.example.kakaoStock.repository;

import com.example.kakaoStock.model.NoTransactionResult;
import com.example.kakaoStock.model.TotalByYearBranchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TotalByYearBranchRepositoryTest {
    @Autowired
    private TotalByYearBranchRepository totalByYearBranchRepository;

    @Test
    void getTotalByYearBranch() {
        List<Map<String, Object>> totalByYearBranchResults = totalByYearBranchRepository.getTotalByYearBranch();

        then(!totalByYearBranchResults.isEmpty());

        for(Map vo : totalByYearBranchResults){
          //  then(2018).isEqualTo(vo.get("year"));
            then(vo.get("brName")).isEqualTo("강남점");
            then(vo.get("brCode")).isEqualTo("C");
            then(vo.get("sumAmt")).isEqualTo(12233267);
        }
    }

    @Test
    void getYear() {
        List<Map<String, Object>> totalByYearBranchResults = totalByYearBranchRepository.getYear();

        then(!totalByYearBranchResults.isEmpty());

        for(Map vo : totalByYearBranchResults){
            then(vo.get("year")).isEqualTo(2018);
        }
    }
}