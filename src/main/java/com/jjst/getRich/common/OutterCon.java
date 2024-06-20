package com.jjst.getRich.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class OutterCon {

    public ResponseEntity<String> getNumbersFromUrl(Integer drawNo, String url) {

        String result = null;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url + drawNo, String.class);
        return response;
    }
}
