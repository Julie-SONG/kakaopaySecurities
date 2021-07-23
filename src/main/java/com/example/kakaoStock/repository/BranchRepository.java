package com.example.kakaoStock.repository;

import com.example.kakaoStock.model.TransResult;
import com.example.kakaoStock.model.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, String> {

    @Query(value = "SELECT account_no as accountNo, account_name as accountName FROM account WHERE trans_dt = :transDt", nativeQuery = true)
    List<TransResult> getBranch(@Param("transDt") String transDt);

}

