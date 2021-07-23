package com.example.kakaoStock.infra;

import com.example.kakaoStock.model.entity.Trans;
import com.example.kakaoStock.repository.TransRepository;
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
public class initTransData {
    @Autowired
    TransRepository transRepository;

    @PostConstruct//거래일자,계좌번호,거래번호,금액,수수료,취소여부
    private void initTrans() throws IOException {
        if (transRepository.count() == 0) {
            Resource resource = new ClassPathResource("거래내역.csv");
            List<Trans> transList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8)
                    .stream().skip(1).map(line -> {
                        String[] split = line.split(",");
                        return Trans.builder().transDt(split[0]).accountNo(split[1]).transID(split[2]).prGoods(split[3]).fee(split[4]).cancelYN(split[5])
                                .build();
                    }).collect(Collectors.toList());
            transRepository.saveAll(transList);
        }
    }
}
