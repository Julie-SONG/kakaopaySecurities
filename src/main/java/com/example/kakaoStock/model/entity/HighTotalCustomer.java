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
public class HighTotalCustomer {
    @Id
    private int year;
    private String name;
    private String acctNo;
    private int sumAmt;
}
