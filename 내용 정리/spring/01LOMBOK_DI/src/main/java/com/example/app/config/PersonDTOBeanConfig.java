package com.example.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.app.domain.DTO.PersonDTO;

@Configuration
public class PersonDTOBeanConfig {
	
	@Bean
	public PersonDTO person3() {
		return PersonDTO.builder()
				.age(999)
				.name("ggg")
				.addr("addr2")
				.build();
		
//		return new PersonDTO("rrr",213,"easf");
	}
	
	@Bean(name="personBean")
	public PersonDTO person4() {
		return new PersonDTO("rraafads",932,"hgfd");
	}
}
