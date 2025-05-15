package com.example.demo.C07PortOne;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
@RequestMapping("/portone")
public class PortOneContoller {

    String RESTAPI_KEY = "";
    String RESTAPI_SECRET = "";

    PortOneTokenResp portOneTokenResp;
    @GetMapping("/index")
    public void index(){
        log.info("get index");
    }

    @GetMapping("/gettoken")
    public void token(){
        log.info("get token");
        // 요청 정보 확인
        String url = "https://api.iamport.kr/users/getToken";
        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
//        header.add("Content-Type","application/json");
        // 요청 바디 설정
        MultiValueMap<String, String> params = new LinkedMultiValueMap();
//        JSONObject params = new JSONObject();
        params.add("imp_key",RESTAPI_KEY);
        params.add("imp_secret",RESTAPI_SECRET);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params,header);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<PortOneTokenResp> response = rt.exchange(url, HttpMethod.POST,entity, PortOneTokenResp.class);
        System.out.println(response.getBody());
        this.portOneTokenResp = response.getBody();
    }

    //결제조회(다건조회)
    @GetMapping("/payments")
    @ResponseBody
    public void payments(){
        log.info("get /payments");
        // 요청 정보 확인
        String url = "https://api.iamport.kr/payments?imp_uid[]=imp_029947672950&merchant_uid[]=";
        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type","application/json");
        header.add("Authorization","Bearer "+this.portOneTokenResp.getResponse().getAccess_token());
        // 요청 바디 설정
//        MultiValueMap<String, String> params = new LinkedMultiValueMap();
//        params.add("imp_uid[]","imp_029947672950");
//        params.add("merchant_uid[]","[]");

        HttpEntity entity = new HttpEntity<>(header);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(url, HttpMethod.GET,entity, String.class);
        System.out.println(response.getBody());

    }
    // 결제 취소
    @GetMapping("/cancel")
    @ResponseBody
    public void cancel(){
        log.info("get cancel");

        //요청 정보 확인
        String url = "https://api.iamport.kr/payments/cancel";
        //요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type","application/json"); //form x
        header.add("Authorization","Bearer "+portOneTokenResp.getResponse().getAccess_token());
        //요청 바디 설정
//        Map<String,Object> params = new HashMap<>();
//        params.put("imp_uid", "");
//        params.put("merchant_uid","");

        JSONObject params = new JSONObject();
        params.put("imp_uid", "");
        params.put("merchant_uid","");

        HttpEntity<String> entity = new HttpEntity<>(params.toString(),header);

        //요청 후 응답확인
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response =
                rt.exchange(url, HttpMethod.POST,entity, String.class);
        System.out.println(response.getBody());

    }

    // 본인 인증
    @GetMapping("/cert/{imp_uid}")
    @ResponseBody
    public void cert(@PathVariable("imp_uid") String imp_uid){
        log.info("get cert "+imp_uid);
        // 요청 정보 확인
        String url = "https://api.iamport.kr/certifications/"+imp_uid;
        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type","application/json");
        header.add("Authorization","Bearer "+portOneTokenResp.getResponse().getAccess_token());
        // 요청 바디 설정

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(header);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(url, HttpMethod.GET,entity, String.class);
        System.out.println(response.getBody());
    }

    @Data
    private static class Response{
        public String access_token;
        public int now;
        public int expired_at;
    }

    @Data
    private static class PortOneTokenResp{
        public int code;
        public Object message;
        public Response response;
    }
}
