package com.example.demo.core.response;


import lombok.Data;

@Data
public abstract class BaseResponse {
    private int code;
    private String msg = "success";
}
