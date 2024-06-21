package com.jjst.getRich.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collections;

@Configuration
public class RestAPITemplateConfig {

    @Value("${openai.api.key}")
    private String apiKey;

    @Bean
    @Qualifier("openaiRestTemplate")
    public RestTemplate openaiRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + apiKey);
            return execution.execute(request, body);
        });

        // Add the message converter
        restTemplate.setMessageConverters(Collections.singletonList(new MappingJackson2HttpMessageConverter()));

        return restTemplate;
    }
}
