package com.jjst.getRich.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultValueDto {

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
    private Integer drwNo;
    private Integer bnusNo;
}
