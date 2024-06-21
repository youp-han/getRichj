package com.jjst.getRich.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ChatRequestDto {

    @JsonProperty("model")
    private String model;

    @JsonProperty("prompt")
    private String prompt;

    private List<MessageDto> messages;


    public ChatRequestDto(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new MessageDto("user", prompt));
    }
}
