package com.example.kakaoStock.service;

import com.example.kakaoStock.repository.TotalByYearBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class TotalByYearBranchService {

    @Autowired
    private TotalByYearBranchRepository totalByYearBranchRepository;

    public List<Map<String, Object>> getTotalByYearBranch() {
        List<Map<String, Object>> dataListTmp = new ArrayList<>();
        List<Map<String, Object>> results = new ArrayList<>();

        List<Map<String, Object>> data = totalByYearBranchRepository.getTotalByYearBranch();
        List<Map<String, Object>> year = totalByYearBranchRepository.getYear();

        for (Map<String, Object> mapTmp : data) {
            LinkedHashMap<String, Object> dataMapTmp = new LinkedHashMap<>();
            dataMapTmp.put("year", mapTmp.get("year"));
            dataMapTmp.put("brName", mapTmp.get("brName"));
            dataMapTmp.put("brCode", mapTmp.get("brCode"));
            dataMapTmp.put("sumAmt", mapTmp.get("sumAmt"));

            dataListTmp.add(dataMapTmp);
        }

        for (int i=0; i<year.size(); i++){
            LinkedHashMap<String, Object> mapTmp = new LinkedHashMap<>();
            List<Map<String, Object>> listTmp = new ArrayList<>();
            mapTmp.put("year",year.get(i).get("year"));
            for(int j=0; j<dataListTmp.size(); j++){
                if(year.get(i).get("year")==dataListTmp.get(j).get("year")){
                    dataListTmp.get(j).remove("year");
                    listTmp.add(dataListTmp.get(j));
                }
            }
            mapTmp.put("dataList",listTmp);
            results.add(mapTmp);
        }
        return results;
    }
}