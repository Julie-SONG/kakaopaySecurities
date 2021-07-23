package com.example.kakaoStock.repository;

import com.example.kakaoStock.model.NoTransactionResult;
import com.example.kakaoStock.model.entity.NoTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoTransactionRepository extends JpaRepository<NoTransaction, String> {

    @Query(value = "\n" +
            "select distinct year, name, acctno from (\n" +
            "select substring(b.trans_dt,0,4) as year,\n" +
            "            a.account_name as name,\n" +
            "            a.account_no as acctNo,\n" +
            "from account a inner join trans b\n" +
            "            where a.account_no = b.account_no\n" +
            "and b.cancelYN = 'Y')\n" +
            "where year in ('2018','2019')\n" +
            "and name in (select  name from (\n" +
            "select distinct year, name, acctno from (\n" +
            "select substring(b.trans_dt,0,4) as year,\n" +
            "            a.account_name as name,\n" +
            "            a.account_no as acctNo,\n" +
            "from account a inner join trans b\n" +
            "            where a.account_no = b.account_no\n" +
            "and b.cancelYN = 'Y')\n" +
            "where year in ('2018','2019'))\n" +
            "group by name\n" +
            "having count(name) = 1)\n", nativeQuery = true)
    List<NoTransactionResult> getNoTransaction();

}

