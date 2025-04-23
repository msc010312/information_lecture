package com.example.app.config;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class PersonComponent {
	private String name;
	private int age;
	private String addr;
	
	PersonComponent(){
		this.name = "qqq";
		this.age = 1;
		this.addr = "wwww";
	}
}
