package com.example.app.domain.DTO;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@ToString
@Data
@AllArgsConstructor // 모든인자 생성자
@NoArgsConstructor // 디폴트 생성자
@Component
@Builder
public class PersonDTO {
	private String name;
	private int age;
	private String addr;
}
