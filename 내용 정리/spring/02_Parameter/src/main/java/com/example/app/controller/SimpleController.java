package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/test")
public class SimpleController {
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public void test1() {
		log.info("GET /test1");
	}
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2() {
		log.info("GET /test2");
		return "test/test2";
	}
	@RequestMapping(value = "/test3", method = {RequestMethod.GET,RequestMethod.POST})
	public String test3() {
		log.info("GET /test3");
		return "test/test3";
	}
}
