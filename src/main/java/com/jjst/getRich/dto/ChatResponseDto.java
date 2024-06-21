package com.jjst.getRich.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChatResponseDto {

    @JsonProperty("choices")
    private List<Choice> choices;

    // constructors, getters and setters
    public List<Choice> getChoices() {
        return choices;
    }
    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public static class Choice {

        @JsonProperty("index")
        private int index;

        @JsonProperty("message")
        private MessageDto message;

        public MessageDto getMessage() {
            return message;
        }
    }

}
