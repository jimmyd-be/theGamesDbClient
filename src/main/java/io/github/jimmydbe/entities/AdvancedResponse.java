package io.github.jimmydbe.entities;

import lombok.Getter;

@Getter
public class AdvancedResponse<T> {
    private int code;
    private String status;
    private T data;
    private IncludeResponse include;
}
