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
public class TotalByYearBranch {
    @Id
    private int year;
    private String brName;
    private String brCode;
    private int sumAmt;
}
