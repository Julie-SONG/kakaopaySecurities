package com.example.kakaoStock.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trans {
    @Id//transDt(split[0]).accountNo(split[1]).transID(split[2]).prGoods(split[3]).fee(split[4]).cancelYN(split[5])
    private String transDt;
    private String accountNo;
    private String transID;
    private String prGoods;
    private String fee;
    private String cancelYN;
}
