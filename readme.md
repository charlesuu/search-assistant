# open API를 활용한 스프링 부트 서버 

### **1. Status Code**
| Code | Description | 
|------|---------|
| 200  | 성공 |
| 400  | 입력 오류 |
| 500  | 서버 오류(외부 연동 실패) |

### **2. Request**
|HTTP METHOD| URL                            |
|------|--------------------------------|
|GET| htttp://{domain}/make/question |

| Name | Type | Description |
|------|------|------------|
|question  | String | 질문할 내용  |


### **3. Response**
| Name       | Type | Description     |
|------------|------|-----------------|
| httpStatus | Integer | http 응답 코드      |
| response   | String | GPT api의 대답 문자열 |

### **4. Exmaple**
- Request :
  `http://{domain}/make/question?question="what's your name?"`

- Response
```json
{
  "code": 200,
  "response": "My name is John"
}
```