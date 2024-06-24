package com.jjst.getRich.module.GenNumbers.service;

import com.jjst.getRich.dto.ResultValueDto;
import com.jjst.getRich.module.DhNumbers.entity.ResultValue;
import com.jjst.getRich.service.ResultGeneratorService;
import com.jjst.getRich.service.ResultValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.List;

@Service
public class ResultGeneratorServiceImpl implements ResultGeneratorService {

    @Autowired
    private ResultValueService resultValueService;

//todo temp codes

    //우선 각 번호의 출현 빈도를 분석해보겠습니다
    public List<ResultValueDto> getRateOfNumberShown (){

        return null;
    }


    //먼저 번호 조합의 출현 패턴을 살펴보겠습니다
    public List<ResultValueDto> getNumberPatterns(){

        return null;
    }


    //번호 간의 상관관계를 분석하여, 특정 번호가 함께 출현하는 경향이 있는지 확인
    public List<ResultValueDto> togetherNumberShownList(){
        return null;
    }



}
