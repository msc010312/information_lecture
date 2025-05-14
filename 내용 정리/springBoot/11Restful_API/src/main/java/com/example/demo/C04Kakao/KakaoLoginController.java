package com.example.demo.C04Kakao;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/kakao/sign")
public class KakaoLoginController {
    String REDIRECT_URI="http://192.168.16.6:8090/kakao/sign/callback";
    String LOGOUT_REDIRECT_URI="http://localhost:8090/kakao/sign/login";
    String CLIENT_ID="";
    String RESPONSE_TYPE="code";

    KakaoTokenResp kakaoTokenResp;
    KaKaoProfile kaKaoProfile;
    KakaoFriendsMsg kakaoFriendsMsg;

    @GetMapping("/main")
    public void mainPage(Model model){
        log.info("get /main");
        // 요청 정보 확인
        String url = "https://kapi.kakao.com/v2/user/me";
        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization","Bearer "+this.kakaoTokenResp.getAccess_token());
        header.add("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
        // 요청 바디 설정

        // Entity
        HttpEntity entity = new HttpEntity(header);

        // 요청 후 응답 설정
        RestTemplate rt = new RestTemplate();
        ResponseEntity<KaKaoProfile> response = rt.exchange(url,HttpMethod.POST,entity,KaKaoProfile.class);
        System.out.println(response.getBody());
        this.kaKaoProfile = response.getBody();
        model.addAttribute("profile",this.kaKaoProfile);
    }

    @GetMapping("/login")
    public String login(){
        log.info("login");
        return "redirect:https://kauth.kakao.com/oauth/authorize?client_id="+CLIENT_ID+"&redirect_uri="+REDIRECT_URI+"&response_type="+RESPONSE_TYPE;
    }

    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code){
        log.info("get callback "+code);
        // 요청 정보 확인
        String url = "https://kauth.kakao.com/oauth/token";
        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
        // 요청 바디 설정
        MultiValueMap<String, String> params = new LinkedMultiValueMap();
        params.add("grant_type","authorization_code");
        params.add("client_id",CLIENT_ID);
        params.add("redirect_uri",REDIRECT_URI);
        params.add("code",code);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params,header);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<KakaoTokenResp> response = rt.exchange(url, HttpMethod.POST,entity,KakaoTokenResp.class);
        System.out.println(response.getBody());
        this.kakaoTokenResp = response.getBody();
        return "redirect:/kakao/sign/main";
        // 요청 후 응답 확인
        // 가공 처리
    }

    @GetMapping("/logout")
    @ResponseBody
    public void logout(){
        log.info("get logout");
        String url = "https://kapi.kakao.com/v1/user/logout";
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization","Bearer "+this.kakaoTokenResp.getAccess_token());
        // Entity
        HttpEntity entity = new HttpEntity(header);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(url,HttpMethod.POST,entity,String.class);
        System.out.println(response.getBody());
    }

    @GetMapping("unlink")
    @ResponseBody
    public void unlink(){
        log.info("Get unlink");
        String url ="https://kauth.kakao.com/oauth/logout";
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization","Bearer "+this.kakaoTokenResp.getAccess_token());
        // Entity
        HttpEntity entity = new HttpEntity(header);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(url,HttpMethod.POST,entity,String.class);
        System.out.println(response.getBody());
    }

    @GetMapping("/logoutall")
    public String logoutall(){
        log.info("Get logoutall");
        return "redirect:https://kauth.kakao.com/oauth/logout?client_id="+CLIENT_ID+"&logout_redirect_uri="+LOGOUT_REDIRECT_URI;
    }

    @GetMapping("/getcodemsg")
    public String getCodeMesaage(){
        log.info("getcodemsg");
        return "redirect:https://kauth.kakao.com/oauth/authorize?client_id="+CLIENT_ID+"&redirect_uri="+REDIRECT_URI+"&response_type="+RESPONSE_TYPE+"&scope=talk_message";
    }

    // message
    @GetMapping("/message/me/{message}")
    public void messageme(@PathVariable("message")String message) {
        log.info("get message me");
        String url="https://kapi.kakao.com/v2/api/talk/memo/default/send";
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization","Bearer "+this.kakaoTokenResp.getAccess_token());
        header.add("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
        // 요청 바디 설정
        MultiValueMap<String, String> params = new LinkedMultiValueMap();
        JSONObject templateObject = new JSONObject();
        templateObject.put("object_type","text");
        templateObject.put("text",message);
        templateObject.put("link",new JSONObject());
        templateObject.put("button_title","");
        params.add("template_object",templateObject.toString());
        // Entity
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params,header);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(url,HttpMethod.POST,entity,String.class);
    }

    @GetMapping("/getcodefriends")
    public String getcodefriends(){
        log.info("getcodefriends");
        return "redirect:https://kauth.kakao.com/oauth/authorize?client_id="+CLIENT_ID+"&redirect_uri="+REDIRECT_URI+"&response_type="+RESPONSE_TYPE+"&scope=friends";
    }

    @GetMapping("/friends")
    public void friends(){
        log.info("GET /kakao/friends");
        //정보
        String url="https://kapi.kakao.com/v1/api/talk/friends";
        //헤더
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization","Bearer "+this.kakaoTokenResp.getAccess_token());

        //본문
        //엔티티
        HttpEntity entity = new HttpEntity<>(header);
        //요청->응답
        RestTemplate rt = new RestTemplate();
        ResponseEntity<KakaoFriendsMsg> response =rt.exchange(url,HttpMethod.GET,entity,KakaoFriendsMsg.class);
        System.out.println(response.getBody());
        this.kakaoFriendsMsg = response.getBody();
    }

    @GetMapping("/message/freinds/{message}")
    @ResponseBody
    public void freindsmessage(@PathVariable("message") String message) {
        log.info(message);
        String url = "https://kapi.kakao.com/v1/api/talk/friends/message/default/send";
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization","Bearer "+this.kakaoTokenResp.getAccess_token());
        header.add("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
        // 요청 바디 설정
        MultiValueMap<String, String> params = new LinkedMultiValueMap();

        // recever
        //Receiver
        JSONArray uuids = new JSONArray();
        List<Element> list = kakaoFriendsMsg.getElements();
        for(int i=0;i<list.size();i++){
            uuids.add( list.get(i).getUuid() );
        }
        System.out.println(uuids.toString());
        // template
        JSONObject templateObject = new JSONObject();
        templateObject.put("object_type","text");
        templateObject.put("text",message);
        templateObject.put("link",new JSONObject());
        templateObject.put("button_title","");

        params.add("receiver_uuids",uuids.toString());
        params.add("template_object",templateObject.toString());
        // Entity
        HttpEntity entity = new HttpEntity(header);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<KakaoFriendsMsg> response = rt.exchange(url,HttpMethod.POST,entity,KakaoFriendsMsg.class);
        System.out.println(response);

    }

    // 토큰
    @Data
    private static class KakaoTokenResp{
        public String access_token;
        public String token_type;
        public String refresh_token;
        public int expires_in;
        public String scope;
        public int refresh_token_expires_in;
    }

    // 사용자 정보
    @Data
    private static class KakaoAccount{
        public boolean profile_nickname_needs_agreement;
        public boolean profile_image_needs_agreement;
        public Profile profile;
        public boolean has_email;
        public boolean email_needs_agreement;
        public boolean is_email_valid;
        public boolean is_email_verified;
        public String email;
    }

    @Data
    private static class Profile{
        public String nickname;
        public String thumbnail_image_url;
        public String profile_image_url;
        public boolean is_default_image;
        public boolean is_default_nickname;
    }

    @Data
    private static class Properties{
        public String nickname;
        public String profile_image;
        public String thumbnail_image;
    }

    @Data
    private static class KaKaoProfile{
        public long id;
        public Date connected_at;
        public Properties properties;
        public KakaoAccount kakao_account;
    }

    // 카카오 친구 메세지 보내기
    @Data
    private static class Element{
        public String profile_nickname;
        public String profile_thumbnail_image;
        public boolean allowed_msg;
        public Object id;
        public String uuid;
        public boolean favorite;
    }

    @Data
    private static class KakaoFriendsMsg{
        public ArrayList<Element> elements;
        public int total_count;
        public Object after_url;
        public int favorite_count;
    }

}
