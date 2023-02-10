package com.hyunho.springboot.web;

import com.hyunho.springboot.service.OpenAIService;
import com.hyunho.springboot.web.dto.RequestQuestionDto;
import com.hyunho.springboot.web.dto.ResponseQuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/make")
@RestController
public class OpenAIController {
    @Autowired
    OpenAIService openAIService;

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public ResponseQuestionDto makeConversation(@Valid RequestQuestionDto requestQuestionVo){
        ResponseQuestionDto responseVo = openAIService.getConversation(requestQuestionVo);

        return responseVo;
    }
}
