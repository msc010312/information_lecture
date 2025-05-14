package com.example.demo.C05Naver;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
@RequestMapping("/naver")
public class NaverLoginController {
    private String NAVER_CLIENT_ID = "";
    private String NAVER_CLIENT_SECRET = "";
    private String REDIRECT_URL = "http://localhost:8090/naver/callback";

    NaverTokenResp naverTokenResp;
    NaverProfile naverProfile;

    @GetMapping("/main")
    public void mainPage(Model model) {
        log.info("get main");
        // 요청 정보 확인
        String url = "https://openapi.naver.com/v1/nid/me";
        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization","Bearer "+this.naverTokenResp.access_token);
        System.out.println(header);
        // 요청 바디 설정

        // Entity
        HttpEntity entity = new HttpEntity(header);

        // 요청 후 응답 설정
        RestTemplate rt = new RestTemplate();
        ResponseEntity<NaverProfile> response = rt.exchange(url,HttpMethod.POST,entity, NaverProfile.class);
        System.out.println(response);
        this.naverProfile = response.getBody();
        model.addAttribute("profile",this.naverProfile);
    }

    @GetMapping("/login")
    public String login(){
        log.info("get login");
        return "redirect:https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id="+NAVER_CLIENT_ID+"&state=STATE_STRING&redirect_uri="+REDIRECT_URL;
    }

    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code,@RequestParam("state") String state){
        log.info("get callback " + code +" "+ state);
        // 요청 정보 확인
        String url = "https://nid.naver.com/oauth2.0/token";
        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
//      header.add("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
        // 요청 바디 설정
        MultiValueMap<String, String> params = new LinkedMultiValueMap();
        params.add("grant_type","authorization_code");
        params.add("client_id",NAVER_CLIENT_ID);
        params.add("client_secret",NAVER_CLIENT_SECRET);
        params.add("code",code);
        params.add("state",state);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params,header);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<NaverTokenResp> response = rt.exchange(url, HttpMethod.POST,entity, NaverTokenResp.class);
        System.out.println(response.getBody());
        this.naverTokenResp = response.getBody();
        return "redirect:/naver/main";
    }

    @GetMapping("/unlink")
    public void unlink() {
        log.info("get unlink");
        // 요청 정보 확인
        String url = "https://nid.naver.com/oauth2.0/token";
        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        // 요청 바디 설정
        MultiValueMap<String, String> params = new LinkedMultiValueMap();
        params.add("grant_type","delete");
        params.add("client_id",NAVER_CLIENT_ID);
        params.add("client_secret",NAVER_CLIENT_SECRET);
        params.add("access_token", naverTokenResp.access_token);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params,header);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(url, HttpMethod.POST,entity, String.class);
        System.out.println(response.getBody());
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:https://nid.naver.com/nidlogin.logout?returl=https://www.naver.com/";
    }

    @Data
    private static class NaverTokenResp{
        public String access_token;
        public String refresh_token;
        public String token_type;
        public String expires_in;
    }

    @Data
    private static class Response{
        public String id;
        public String profile_image;
        public String email;
        public String name;
    }

    @Data
    private static class NaverProfile{
        public String resultcode;
        public String message;
        public Response response;
    }
}
