package com.example.demo.C04Kakao;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
@RequestMapping("/kakao/pay")
public class KakaoPayController {
    private String secretKey = "";
    @GetMapping("/req")
    @ResponseBody
    public void reg(){
        log.info("get req");
        // 요청 정보 확인
        String url = "https://open-api.kakaopay.com/online/v1/payment/ready";
        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization","SECRET_KEY "+secretKey);
        header.add("Content-Type","application/json");
        // 요청 바디 설정
//        MultiValueMap<String, String> params = new LinkedMultiValueMap();
        JSONObject params = new JSONObject();
        params.put("cid","TC0ONETIME");
        params.put("partner_order_id","partner_order_id");
        params.put("partner_user_id","partner_user_id");
        params.put("item_name","초코파이");
        params.put("quantity","1");
        params.put("total_amount","1000001");
        params.put("vat_amount","200");
        params.put("tax_free_amount","0");
        params.put("approval_url","https://localhost:8090/kakao/pay/success");
        params.put("fail_url","https://localhost:8090/kakao/pay/fail");
        params.put("cancel_url","https://localhost:8090/kakao/pay/cancel");

        HttpEntity<JSONObject> entity = new HttpEntity<>(params,header);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(url, HttpMethod.POST,entity,String.class);
        System.out.println(response.getBody());
    }

    @GetMapping("/success")
    public void success(){
        log.info("get success");
    }

    @GetMapping("fail")
    public void fail(){
        log.info("get fail");
    }

    @GetMapping("cancel")
    public void cancel(){
        log.info("get cancel");
    }
}
