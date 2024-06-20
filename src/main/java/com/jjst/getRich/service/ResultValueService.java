package com.jjst.getRich.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jjst.getRich.dto.ResultValueDto;
import com.jjst.getRich.module.DhNumbers.entity.ResultValue;

import java.util.List;

public interface ResultValueService {

    List<ResultValue> getAll();
    ResultValueDto getTheLatestNumber() throws JsonProcessingException;


}
