package com.example.kakaoStock.infra;

import com.example.kakaoStock.model.entity.Branch;
import com.example.kakaoStock.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class initBranchData {
    @Autowired
    BranchRepository branchRepository;

    @PostConstruct
    private void initTrans() throws IOException {
        if (branchRepository.count() == 0) {
            Resource resource = new ClassPathResource("관리점정보.csv");
            List<Branch> branchList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8)
                    .stream().skip(1).map(line -> {
                        String[] split = line.split(",");
                        return Branch.builder().branchCode(split[0]).branchName(split[1])
                                .build();
                    }).collect(Collectors.toList());
            branchRepository.saveAll(branchList);
        }
    }
}
