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
public class Branch {
    @Id//return Trans.builder().branchCode(split[0]).branchName(split[1])
    private String branchCode;
    private String branchName;
}
