package com.example.demo.C05Naver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
@RequestMapping("/naver/search")
public class NaverSearchController {
    private String NAVER_CLIENT_ID = "y14mUcAB_8xyFdSSQLon";
    private String NAVER_CLIENT_SECRET = "lesMqdq2Jz";

    @GetMapping("/book/{keyword}")
    public void book(@PathVariable("keyword") String keyword){
        log.info("get search/book " + keyword);
        // 요청 정보 확인
        String url = "https://openapi.naver.com/v1/search/book.json?query="+keyword;
        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        header.add("X-Naver-Client-Id",NAVER_CLIENT_ID);
        header.add("X-Naver-Client-Secret-Type",NAVER_CLIENT_SECRET);
        // 요청 바디 설정
//        MultiValueMap<String, String> params = new LinkedMultiValueMap();
//        params.add("grant_type","authorization_code");
//        params.add("client_id",NAVER_CLIENT_ID);
//        params.add("client_secret",NAVER_CLIENT_SECRET);
//        params.add("code",code);
//        params.add("state",state);

        HttpEntity entity = new HttpEntity<>(header);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(url, HttpMethod.GET,entity, String.class);
        System.out.println(response.getBody());
    }
}
