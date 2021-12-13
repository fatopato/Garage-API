package com.assessment.garage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class BaseResponse {
    private Object data;
    private String error;
    private HttpStatus status;
}
