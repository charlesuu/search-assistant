package com.hyunho.springboot.web.dto.gpt;

import lombok.Data;

import java.io.Serializable;

@Data
public class BotRequest implements Serializable {
    private String message;
    private String author;
    //@Data롬복 하나로 생성자, toEntity 함수 및 빌더 다 나오나?
}



