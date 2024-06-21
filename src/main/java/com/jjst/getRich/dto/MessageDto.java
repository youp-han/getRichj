package com.jjst.getRich.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto {
    private String role;
    @JsonProperty("content")
    private String content;

    public String getContent() {
        return content;
    }

    // Constructor
    public MessageDto(String role, String content) {
        this.role = role;
        this.content = content;
    }

}
