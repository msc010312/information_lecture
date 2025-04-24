package com.example.app.controller;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.DTO.UserDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserContoller {
	
	@InitBinder
	public void dataBinder(WebDataBinder webDataBinder) {
		log.info("memoController databinder" + webDataBinder);
		webDataBinder.registerCustomEditor(LocalDate.class, "birthday", new DateTestEditor());
		webDataBinder.registerCustomEditor(String.class, "phone", new phoneEditor());
	}
	
	
	@GetMapping("/join")
	public void joinGet() {
		log.info("get /join");
	}

	@PostMapping("/join")
	public void joinPost(@Valid UserDto ud, BindingResult br,Model model) {
		log.info("post /join" + ud);
		if (br.hasErrors()) {
			for (FieldError error : br.getFieldErrors()) {
				log.info("error field : " + error.getField() + "error message : " + error.getDefaultMessage());
				model.addAttribute(error.getField(),error.getDefaultMessage());
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
				text = text.replaceAll("~","-");
				date = LocalDate.parse(text,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			}
			setValue(date);
		}
	}
	
	private static class phoneEditor extends PropertyEditorSupport {

		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			log.info("dataText invoke : " + text);
			text = text.replaceAll("-", "");
			setValue(text);
		}
	}
}
