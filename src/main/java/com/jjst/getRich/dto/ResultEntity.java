package com.jjst.getRich.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "MyResultEntityBuilder")
public class ResultEntity<T> {

    private String status;
    private T data;
    private Integer count;

    public static class MyResultEntityBuilder<T>{

    }
}
