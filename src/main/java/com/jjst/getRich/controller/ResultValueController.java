package com.jjst.getRich.controller;

import com.jjst.getRich.entity.ResultEntity;
import com.jjst.getRich.dto.ResultValueDto;
import com.jjst.getRich.service.CSVConverterService;
import com.jjst.getRich.service.ResultValueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/result")
public class ResultValueController {

    @Autowired
    private ResultValueService service;

    @Autowired
    private CSVConverterService csvConverterService;

    //updateDhNumbers
    //if the local db is behind the drawno from Dhsite, it updates from the site.
    //if the local db is the latest, it prints the last set from the db
    @GetMapping("")
    public ResponseEntity<ResultEntity> updateDhNumbers() throws Exception {

        ResultValueDto result = null;
        Integer theLastDraw = 0;

        //로컬db 에서 데이터 확인 하여 마지막 번호를 가지고 온다.
        try{
            result = service.getTheLatestNumber();
        }catch(Exception e){
            throw new Exception(e.getMessage().toString());
        }

        return ResponseEntity.ok(ResultEntity.builder()
                .status("ok")
                .data(result).count(1)
                .build());


    }

    @GetMapping("/csvFile")
    public ResponseEntity<ResultEntity> convertDataToFile(){

        try{
            csvConverterService.exportToCsv("win_history.csv");

        }catch(IOException e){

        }

        return ResponseEntity.ok(ResultEntity.builder()
                .status("Data Exported to CSV successfully")
                .data(null).count(1)
                .build());
    }


}
