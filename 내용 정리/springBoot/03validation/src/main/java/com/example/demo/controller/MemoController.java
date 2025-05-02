package com.example.demo.controller;

import com.example.demo.domain.DTO.MemoDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {

	@InitBinder
	public void dataBinder(WebDataBinder webDataBinder) {
		log.info("memoController databinder" + webDataBinder);
		webDataBinder.registerCustomEditor(LocalDate.class, "dateTest", new DateTestEditor());
	}

	@GetMapping("/add")
	public void addGet() {
		log.info("get /memo/add");
	}

	@PostMapping("/add")
	public void addPost(@Valid MemoDTO md, BindingResult br, Model model) {
		log.info("post /memo/add" + md);
		if (br.hasErrors()) {
			// log.info("error : " + br.getFieldError("id").getDefaultMessage());
			for (FieldError error : br.getFieldErrors()) {
				log.info("error field : " + error.getField() + "error message : " + error.getDefaultMessage());
				model.addAttribute(error.getField(), error.getDefaultMessage());
			}
		}
	}

	private static class DateTestEditor extends PropertyEditorSupport {

		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			log.info("dataText invoke : " + text);
			LocalDate date = null;
			if(text.isEmpty()) {
				date = LocalDate.now();
			} else {
				//yyyy#MM#dd
				text = text.replaceAll("#","-");
				date = LocalDate.parse(text,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			}
			setValue(date);
		}
	}
}
