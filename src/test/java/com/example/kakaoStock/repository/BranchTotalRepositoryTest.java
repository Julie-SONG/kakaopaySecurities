package com.example.kakaoStock.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BranchTotalRepositoryTest {
    @Autowired
    private BranchTotalRepository branchTotalRepository;

    @ParameterizedTest
    @ValueSource(strings = {"잠실점"})
    void getBranchTotal(String branch) {
        /*Map<String, Object> branchTotalResults = branchTotalRepository.getBranchTotal(branch);

        then(!branchTotalResults.isEmpty());

            then("brName").isEqualTo(branchTotalResults.get("잠실점"));
            then("brCode").isEqualTo(branchTotalResults.get("D"));
            then("sumAmt").isEqualTo(branchTotalResults.get(4000000));*/
    }

    @ParameterizedTest
    @ValueSource(strings = {"판교점"})
    void getPangyoTotal(String pangyo) {
        /*Map<String, Object> PangyoTotalResults = branchTotalRepository.getPangyoTotal(pangyo);

        then(!PangyoTotalResults.isEmpty());

        then("brName").isEqualTo(PangyoTotalResults.get("판교점"));
        then("brCode").isEqualTo(PangyoTotalResults.get("A"));
        then("sumAmt").isEqualTo(PangyoTotalResults.get(132485500));*/
    }
}