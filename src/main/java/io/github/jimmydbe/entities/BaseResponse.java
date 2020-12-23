package io.github.jimmydbe.entities;

import lombok.Getter;

@Getter
public class BaseResponse<T> {
    private int code;
    private String status;
    private T data;
}
