package com.example.app.domain.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter,setter,toString
@AllArgsConstructor // 모든인자 생성자
@NoArgsConstructor // 디폴트 생성자
@Component
@Builder
public class MemoDTO {
	@Min(value = 10, message="ID는 10이상이어야합니다")
	@Max(value = 65535, message = "ID의 최대숫자는 65535이하여야합니다")
	@NotNull(message = "ID는 필수항목입니다")
	private Integer id;
	@NotBlank(message = "메모를 입력하세요")
	private String text;
	@NotBlank(message = "메모를 입력하세요")
	@Email(message = "example@example.com에 맞게 입력해주세요")
	private String writer;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@NotNull(message = "날짜정보를 입력하세요")
	private LocalDateTime createAt;
	
	private LocalDate dateTest;
}
