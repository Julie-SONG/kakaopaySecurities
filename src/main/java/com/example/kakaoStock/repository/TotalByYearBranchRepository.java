package com.example.kakaoStock.repository;

import com.example.kakaoStock.model.entity.TotalByYearBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TotalByYearBranchRepository extends JpaRepository<TotalByYearBranch, String> {

    @Query(value = "select year ,brName, brCode, sum(sumAmt) as sumAmt from (\n" +
            "select substring(t.trans_dt,0,4) as year,\n" +
            "b.branch_name as brName,\n" +
            "b.branch_code as brCode,\n" +
            "sum(cast(t.pr_goods as int(20)) - cast(fee as int(20))) as sumAmt\n" +
            "from account a, branch b, trans t\n" +
            "where a.branch_code= b.branch_code\n" +
            "and a.account_no = t.account_no\n" +
            "and t.cancelYN = 'N'\n" +
            "group by t.trans_dt)\n" +
            "group by brName, year\n" +
            "order by year,sumAmt desc\n", nativeQuery = true)
    List<Map<String, Object>> getTotalByYearBranch();

    @Query(value = "select distinct year from (\n" +
            "select substring(t.trans_dt,0,4) as year,\n" +
            "b.branch_name as brName,\n" +
            "b.branch_code as brCode,\n" +
            "sum(cast(t.pr_goods as int(20)) - cast(fee as int(20))) as sumAmt\n" +
            "from account a, branch b, trans t\n" +
            "where a.branch_code= b.branch_code\n" +
            "and a.account_no = t.account_no\n" +
            "and t.cancelYN = 'N'\n" +
            "group by t.trans_dt)\n" +
            "order by year\n", nativeQuery = true)
    List<Map<String, Object>> getYear();

}

