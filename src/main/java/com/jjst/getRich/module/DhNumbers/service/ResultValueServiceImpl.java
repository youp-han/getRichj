package com.jjst.getRich.module.DhNumbers.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjst.getRich.common.OutterCon;
import com.jjst.getRich.common.Utility;
import com.jjst.getRich.dto.ResultValueDto;
import com.jjst.getRich.module.DhNumbers.entity.ResultValue;
import com.jjst.getRich.module.DhNumbers.repository.ResultValueRepository;
import com.jjst.getRich.service.ResultValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultValueServiceImpl implements ResultValueService {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ResultValueRepository repository;

    private String url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=";

    @Override
    public List<ResultValue> getAll() {
        return repository.findAll();
    }

    //returns the lastest win number
    //checks the last number and if neccessary it updates to the latest number.
    @Override
    public ResultValueDto getTheLatestNumber() throws JsonProcessingException {

        ResultValueDto resultValueDto;
        Integer dbCount = this.getLatestDrawNo();         //test count = 1124;
        boolean isOutDated = this.checkDates(dbCount);

        List<ResultValueDto> resultValueDtoList;
        List<ResultValue> resultValueList;

        if(isOutDated){
            resultValueDtoList = this.getListOfResults(dbCount + 1);
            resultValueList = new ArrayList<>();

            //dto->entity
            for (ResultValueDto dto : resultValueDtoList){
                resultValueList.add(toEntity(dto));
            }
            //save to the localDB
            if (resultValueList.size()>0) {
                repository.saveAll(resultValueList);
            }

        }else{
            resultValueDtoList  = new ArrayList<>();
        }


        //returns the latest draw
        if (!resultValueDtoList.isEmpty()) {
            resultValueDto = resultValueDtoList.get(resultValueDtoList.size() - 1);
        } else {
            //if null, and the local db is empty, it returns null
            if(dbCount == 0) {
                resultValueDto = null;
            }else{
                //if null, then gets the lastes from the local db
                resultValueDto = toDto(repository.findResultValueByDrwNo(dbCount));
            }
        }

        return resultValueDto;
    }

    private List<ResultValueDto> getListOfResults(Integer count) throws JsonProcessingException {
        List<ResultValueDto> resultValueDtoList = new ArrayList<>();
        ResultValueDto resultValue;
        boolean flag = true;

        while(flag){
            resultValue = getNumbers(count);
            if(resultValue != null){
                count ++;
                resultValueDtoList.add(resultValue);
            }else{
                flag = false;
            }
        }

        return resultValueDtoList;
    }

    //returns the lastest DrawNo
    private Integer getLatestDrawNo(){
        Integer maxDrawNo = repository.findMaxDrawNo();
        return (maxDrawNo != null) ? maxDrawNo : 0;

    }

    private boolean checkDates(Integer maxDrawNo){
        ResultValue value = repository.findResultValueByDrwNo(maxDrawNo);
        LocalDate latestDbDate = null;
        try{
            latestDbDate = Utility.stringToTime(value.getDrwNoDate());
        }catch (DateTimeParseException e) {
            //System.err.println("Error occurred: " + e.getMessage());
            latestDbDate = null;
        }

        Long diff= Utility.dateDiffFromToday(latestDbDate);

        if(diff>7){
            return true;
        }else{
            return false;
        }
    }

    //returns the result for the requested DrawNo
    private ResultValueDto getNumbers(Integer drawNo) throws JsonProcessingException {
        ResultValueDto result = null;
        OutterCon con = new OutterCon();
        ResponseEntity<String> response = con.getNumbersFromUrl(drawNo, url);
        if (response.getStatusCode().is2xxSuccessful()) {
            if(!response.getBody().contains("fail")) {
                result= mapper.readValue(response.getBody().toString(), ResultValueDto.class);
            }
        }
        return result;
    }


    //changes the entity to dto
    private ResultValueDto toDto(ResultValue value){
        if(value== null) return null;

        return ResultValueDto.builder()
                .drwNoDate(value.getDrwNoDate())
                .drwNo(value.getDrwNo())
                .drwtNo1(value.getDrwtNo1())
                .drwtNo2(value.getDrwtNo2())
                .drwtNo3(value.getDrwtNo3())
                .drwtNo4(value.getDrwtNo4())
                .drwtNo5(value.getDrwtNo5())
                .drwtNo6(value.getDrwtNo6())
                .bnusNo(value.getBnusNo())
                .firstAccumamnt(value.getFirstAccumamnt())
                .firstWinamnt(value.getFirstWinamnt())
                .returnValue(value.getReturnValue())
                .build();

    }

    //changes the dto to entity
    private ResultValue toEntity(ResultValueDto dto) {
        if (dto == null) return null;
        ResultValue resultValue = new ResultValue();
        resultValue.setDrwNoDate(dto.getDrwNoDate());
        resultValue.setDrwNo(dto.getDrwNo());
        resultValue.setDrwtNo1(dto.getDrwtNo1());
        resultValue.setDrwtNo2(dto.getDrwtNo2());
        resultValue.setDrwtNo3(dto.getDrwtNo3());
        resultValue.setDrwtNo4(dto.getDrwtNo4());
        resultValue.setDrwtNo5(dto.getDrwtNo5());
        resultValue.setDrwtNo6(dto.getDrwtNo6());
        resultValue.setBnusNo(dto.getBnusNo());
        resultValue.setFirstAccumamnt(dto.getFirstAccumamnt());
        resultValue.setFirstWinamnt(dto.getFirstWinamnt());
        resultValue.setReturnValue(dto.getReturnValue());
        return resultValue;
    }

}
