package com.jjst.getRich.module.CSVConverter;

import com.jjst.getRich.dto.ResultValueDrwNoDto;
import com.jjst.getRich.module.DhNumbers.entity.ResultValue;
import com.jjst.getRich.service.CSVConverterService;
import com.jjst.getRich.service.ResultValueService;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVConverterServiceImpl implements CSVConverterService {

    @Autowired
    ResultValueService resultValueService;


    @Override
    public void exportToCsv(String filePath) throws IOException {
        List<ResultValue> resultValueList = resultValueService.getAll();
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))){
            // Write header
            String[] header = {"drwNo", "drwtNo1", "drwtNo2", "drwtNo3", "drwtNo4", "drwtNo5", "drwtNo6", "bnusNo"};
            writer.writeNext(header);

            // Write data
            for (ResultValue value : resultValueList) {
                String[] line = {
                        value.getDrwtNo1() != null ? value.getDrwNo().toString() : "",
                        value.getDrwtNo1() != null ? value.getDrwtNo1().toString() : "",
                        value.getDrwtNo2() != null ? value.getDrwtNo2().toString() : "",
                        value.getDrwtNo3() != null ? value.getDrwtNo3().toString() : "",
                        value.getDrwtNo4() != null ? value.getDrwtNo4().toString() : "",
                        value.getDrwtNo5() != null ? value.getDrwtNo5().toString() : "",
                        value.getDrwtNo6() != null ? value.getDrwtNo6().toString() : "",
                        value.getBnusNo() != null ? value.getBnusNo().toString() : ""
                };
                writer.writeNext(line);
            }
        }
    }
}
