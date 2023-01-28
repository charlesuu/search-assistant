package com.hyunho.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//Dto == 컨트롤러에서 Request/Response 용으로 사용하는 데이터 유닛을 정의해 둔 것인가? 아니면 Dto가 다른 일도 하나?

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
