package com.example.demo.core.response;

import com.example.demo.db.model.StudentHomework;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class DataResponses<T> extends BaseResponse {
    private T data;
}
