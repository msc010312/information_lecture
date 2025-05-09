package com.example.demo.OpenData;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/opendata")
public class OpenDataController02 {
    String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
    String serviceKey = "xYZ80mMcU8S57mCCY/q8sRsk7o7G8NtnfnK7mVEuVxdtozrl0skuhvNf34epviHrru/jiRQ41FokE9H4lK0Hhg==";
    String pageNo = "1";
    String numOfRows = "10";
    String dataType = "JSON";
    String baseData = "20250509";
    String basetime = "1600";
    String nx = "89";
    String ny ="90";
    @GetMapping("/forcast")
    public void forcast(Model model) {
        log.info("get open data forcast");
        url+="?serviceKey="+serviceKey;
        url+="&numOfRows="+numOfRows;
        url+="&pageNo="+pageNo;
        url+="&dataType="+dataType;
        url+="&base_date="+baseData;
        url+="&base_time="+basetime;
        url+="&nx="+nx;
        url+="&ny="+ny;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Root> response = restTemplate.exchange(url, HttpMethod.GET,null, Root.class);
        System.out.println(response);

        Root root = response.getBody();
        Response rs = root.getResponse();
        Body body = rs.getBody();
        Items items = body.getItems();
        List<Item> list = items.getItem();
        list.stream().forEach(System.out::println);
        model.addAttribute("list", list);
    }

    @Data
    private static class Body{
        public String dataType;
        public Items items;
        public int pageNo;
        public int numOfRows;
        public int totalCount;
    }
    @Data
    private static class Header{
        public String resultCode;
        public String resultMsg;
    }
    @Data
    private static class Item{
        public String baseDate;
        public String baseTime;
        public String category;
        public int nx;
        public int ny;
        public String obsrValue;
    }
    @Data
    private static class Items{
        public ArrayList<Item> item;
    }
    @Data
    private static class Response{
        public Header header;
        public Body body;
    }
    @Data
    private static class Root{
        public Response response;
    }
}
