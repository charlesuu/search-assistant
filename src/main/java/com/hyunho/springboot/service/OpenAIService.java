package com.hyunho.springboot.service;

import com.hyunho.springboot.web.dto.RequestQuestionDto;
import com.hyunho.springboot.web.dto.ResponseQuestionDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@PropertySource("classpath:apikey.properties")
public class OpenAIService {

    @Value("${apikey}")
    private String API_KEY;

    private static final String ENDPOINT = "https://api.openai.com/v1/completions";


    public ResponseQuestionDto getConversation(RequestQuestionDto requestQuestionVo) {
        ResponseQuestionDto responseQuestionDto = new ResponseQuestionDto();
        try {

            String answer = generateText(requestQuestionVo.getQuestion(), 0.5f, 1000);

            responseQuestionDto.setHttpStatus(200);
            String answerFilter1 = answer.replaceAll("\n", "");
            String result =  answerFilter1.replaceAll("\\.","");
            result =  result.replaceAll("\\\\","");
            result =  result.replaceAll("\"","");

            responseQuestionDto.setResponse(result);
        } catch (Exception e) {
            responseQuestionDto.setHttpStatus(500);
            responseQuestionDto.setResponse("generateText error(서버 에러)");
        }
        return responseQuestionDto;
    }

    public String generateText(String prompt, float temperature, int maxTokens) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + API_KEY);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model","text-davinci-003");
        requestBody.put("prompt", prompt);
        requestBody.put("temperature", temperature);
        requestBody.put("max_tokens", maxTokens);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.postForEntity(ENDPOINT, requestEntity, Map.class);
        Map<String, Object> responseBody = response.getBody();
        System.out.println(responseBody.toString());

        List<Map<String, Object>> choicesList = (List<Map<String, Object>>)responseBody.get("choices");
        Map<String, Object> choiceMap = choicesList.get(0);
        String answer = (String)choiceMap.get("text");

        return answer;
    }

}
