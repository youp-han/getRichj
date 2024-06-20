package com.jjst.getRich.module.DhNumbers.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ResultValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long totSellamnt; // 총판매금액
    private String returnValue;
    private String drwNoDate;
    private Long firstWinamnt;
    private Integer firstPrzwnerCo; // 1등당첨인원수
    private Long firstAccumamnt; // 1등 당첨금액
    private Integer drwtNo6;
    private Integer drwtNo5;
    private Integer drwtNo4;
    private Integer drwtNo3;
    private Integer drwtNo2;
    private Integer drwtNo1;
    private Integer drwNo; //회차
    private Integer bnusNo;

}
