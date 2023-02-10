package com.hyunho.springboot.web.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseQuestionDto {
    private Integer httpStatus;
    private String response;
}
