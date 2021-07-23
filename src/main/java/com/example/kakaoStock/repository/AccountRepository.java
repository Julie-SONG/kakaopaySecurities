package com.example.kakaoStock.repository;

import com.example.kakaoStock.model.entity.Account;
import com.example.kakaoStock.model.AccountResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

      @Query(value = "SELECT a.account_no as accountNo, a.account_name as accountName FROM Account a WHERE a.branch_code = :branchCode", nativeQuery = true)
     List<AccountResult> getAccount(@Param("branchCode") String branchCode);
}

