package com.example.kakaoStock.repository;

import com.example.kakaoStock.model.HighTotalCustomerResult;
import com.example.kakaoStock.model.entity.HighTotalCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HighTotalCustomerRepository extends JpaRepository<HighTotalCustomer, String> {

    @Query(value = "select year, name, acctNo, sumAmt from\n" +
            "(select  year, name, acctNo, sum(sumAmt) as sumAmt, ROW_NUMBER() OVER(PARTITION BY year ORDER BY sum(sumAmt) DESC) as rowidx from (\n" +
            "select substring(b.trans_dt,0,4) as year,\n" +
            "a.account_name as name,\n" +
            "a.account_no as acctNo,\n" +
            "sum(cast(pr_goods as int(20)) - cast(fee as int(20))) as sumAmt\n" +
            "from account a inner join trans b\n" +
            "where a.account_no = b.account_no and b.cancelYN = 'N'\n" +
            "group by trans_dt\n" +
            ") group by year, name, acctNo\n" +
            ") where rowidx = '1' and year in ('2018', '2019')\n", nativeQuery = true)
    List<HighTotalCustomerResult> getHighTotalCustomer();

}

