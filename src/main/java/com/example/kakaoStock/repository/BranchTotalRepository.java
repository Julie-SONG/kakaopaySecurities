package com.example.kakaoStock.repository;

import com.example.kakaoStock.model.entity.BranchTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface BranchTotalRepository extends JpaRepository<BranchTotal, String> {

    @Query(value = "select \n" +
            "            b.branch_name as brName,\n" +
            "            b.branch_code as brCode,\n" +
            "            sum(cast(t.pr_goods as int(20)) - cast(fee as int(20))) as sumAmt\n" +
            "            from account a, branch b, trans t\n" +
            "            where a.branch_code= b.branch_code\n" +
            "            and a.account_no = t.account_no\n" +
            "            and t.cancelYN = 'N'\n" +
            "            and b.branch_name = :brName\n" +
            "            group by b.branch_name", nativeQuery = true)
    Map<String, Object> getBranchTotal(@Param("brName") String brName);

    @Query(value = "select  b.branch_name as brName,\n" +
            "           b.branch_code as brCode,\n" +
            "            sum(cast(t.pr_goods as int(20)) - cast(fee as int(20))) \n" +
            "                + (select sum(cast(t.pr_goods as int(20)) - cast(fee as int(20)))  \n" +
            "                    from account a, branch b, trans t\n" +
            "                    where a.branch_code= b.branch_code\n" +
            "                    and a.account_no = t.account_no\n" +
            "                    and t.cancelYN = 'N'\n" +
            "                        and b.branch_name = '분당점') as sumAmt\n" +
            "from account a, branch b, trans t\n" +
            "where a.branch_code= b.branch_code\n" +
            "and a.account_no = t.account_no\n" +
            "and t.cancelYN = 'N'\n" +
            "and b.branch_name = :brName \n" +
            "group by b.branch_name", nativeQuery = true)
    Map<String, Object> getPangyoTotal(@Param("brName") String brName);
}

