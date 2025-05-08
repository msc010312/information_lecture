package com.example.app.restController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.dto.MemoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/rest")
public class RestController01 {

    // text
    @GetMapping(value="/getText", produces=MediaType.TEXT_PLAIN_VALUE)
    public String f1() {
        log.info("Get /rest/getText");
        return "hello world";
    }

    // json
    @GetMapping(value="/getJson", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MemoDto f2() {
        log.info("Get /rest/getJson");
        return new MemoDto(11,"abcd","eeee",LocalDateTime.now());
    }

    //XML
    @GetMapping(value="getXml", produces=MediaType.APPLICATION_XML_VALUE)
    public MemoDto f3() {
        log.info("Get /rest/getXml");
        return new MemoDto(11,"abcd","eeee",LocalDateTime.now());
    }

    //Xml list
    @GetMapping(value="/getXmlList" , produces=MediaType.APPLICATION_XML_VALUE)
    public List<MemoDto> f4() {
        log.info("GET /rest/getXmlList...");
        List<MemoDto> list = new ArrayList();
        for(int i=1;i<=	50;i++) {
            list.add(new MemoDto(i,"A"+i,"eee",LocalDateTime.now()));
        }
        return list;
    }

    @GetMapping(value="/getXmlList2/{show}" , produces=MediaType.APPLICATION_XML_VALUE)
    public  ResponseEntity< List<MemoDto> > f5(@PathVariable("show") boolean show) {
        log.info("GET /rest/getXmlList2...");

        if(show) {
            List<MemoDto> list = new ArrayList();
            for(int i=0;i<50;i++) {
                list.add(new MemoDto(i,"A"+i,"eee",LocalDateTime.now()));
            }
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);
    }
}
