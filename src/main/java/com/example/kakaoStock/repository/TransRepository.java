package com.example.kakaoStock.repository;

import com.example.kakaoStock.model.TransResult;
import com.example.kakaoStock.model.entity.Trans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransRepository extends JpaRepository<Trans, String> {

    @Query(value = "SELECT account_no as accountNo, account_name as accountName FROM account WHERE trans_dt = :transDt", nativeQuery = true)
    List<TransResult> getTrans(@Param("transDt") String transDt);

}

