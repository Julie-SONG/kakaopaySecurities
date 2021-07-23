package com.example.kakaoStock.service;

import com.example.kakaoStock.repository.BranchTotalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
@Transactional
public class BranchTotalService {

    @Autowired
    private BranchTotalRepository branchTotalRepository;

    public ResponseEntity<Map<String, Object>> getBranchTotal(String brName){
        LinkedHashMap<String, Object> results = new LinkedHashMap<>();

        if(brName.equals("판교점")){
                Map<String, Object> selectPangyo = branchTotalRepository.getPangyoTotal(brName);
                results.put("brName", selectPangyo.get("brName"));
                results.put("brCode", selectPangyo.get("brCode"));
                results.put("sumAmt", selectPangyo.get("sumAmt"));
                return ResponseEntity.ok().body(results);
            }

        Map<String, Object> selectBranch = branchTotalRepository.getBranchTotal(brName);
        results.put("brName", selectBranch.get("brName"));
        results.put("brCode", selectBranch.get("brCode"));
        results.put("sumAmt", selectBranch.get("sumAmt"));

            if (results.get("brName").equals("분당점")) {
                LinkedHashMap<String, Object> FailResults = new LinkedHashMap<>();
                FailResults.put("코드", "404");
                FailResults.put("메세지", "br code not found error");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FailResults);
            }

        if(results.get("sumAmt").equals("")||results.get("sumAmt")==null){
            return ResponseEntity.noContent().build();
        }

            return ResponseEntity.ok().body(results);
        }
}