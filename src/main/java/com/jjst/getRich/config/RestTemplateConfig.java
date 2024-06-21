package com.jjst.getRich.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateConfig {

    public ResponseEntity<String> getNumbersFromUrl(Integer drawNo, String url) {

        String result = null;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url + drawNo, String.class);
        return response;
    }
}
