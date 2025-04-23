package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {
	
	@GetMapping("/add")
	public void addGet() {
		log.info("get /memo/add");
	}
	
	@PostMapping("/add")
	public void addPost() {
		log.info("post /memo/add");
	}
}
