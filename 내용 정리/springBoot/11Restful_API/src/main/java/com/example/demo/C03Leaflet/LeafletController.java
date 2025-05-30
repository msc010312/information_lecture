package com.example.demo.C03Leaflet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/leaflet")
public class LeafletController {
    @GetMapping("/index")
    public void index(){
        log.info("get /index");
    }
}
