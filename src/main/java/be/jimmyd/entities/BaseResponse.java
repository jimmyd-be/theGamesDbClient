package be.jimmyd.entities;

import lombok.Getter;

import java.util.List;

@Getter
public class BaseResponse<T> {
    private int code;
    private String status;
    private T data;
}
