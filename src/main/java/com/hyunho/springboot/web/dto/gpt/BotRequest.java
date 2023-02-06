package com.hyunho.springboot.web.dto.gpt;

import lombok.Data;

import java.io.Serializable;

@Data
public class BotRequest implements Serializable {
    private String message;
}



