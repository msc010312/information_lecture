package com.example.demo.controller;

import com.example.demo.domain.dto.MemoDto;
import com.example.demo.domain.entity.Memo;
import com.example.demo.domain.repository.MemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/th")
@Slf4j
public class ThymeLeafTestController {

    @Autowired
    MemoRepository memoRepository;

    @GetMapping("/test1")
    public void test1(Model model) {
        log.info("get test1 mapping");
        model.addAttribute("name","hong");
        MemoDto memo = new MemoDto();
        memo.setId(111);
        memo.setText("aaa");
        memo.setWriter("aaa");
        model.addAttribute("memo",memo);

        model.addAttribute("isAuth",false);

        List<Memo> memoList = memoRepository.findAll();
        model.addAttribute("memoList",memoList);
    }

    @GetMapping("/param1")
    public void param1(@ModelAttribute MemoDto memoDto){
        log.info("get param1 memodto"+ memoDto);
    }

    @GetMapping("/param2/{id}/{text}/{writer}")
    public void param2(@ModelAttribute MemoDto memoDto){
        log.info("get param2 memodto"+ memoDto);
    }

    @GetMapping("/test2")
    public void test2() {
        log.info("get test2");
    }
}
