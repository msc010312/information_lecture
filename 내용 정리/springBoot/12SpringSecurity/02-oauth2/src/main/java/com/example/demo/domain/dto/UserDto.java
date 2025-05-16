package com.example.demo.domain.dto;

import com.example.demo.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	private String username;		//유저ID
	private String password;	//패스워드
	private String role;

	// DTO -> ENTITY
	public User toEntity() {
		return User.builder()
				.username(this.getUsername())
				.password(this.getPassword())
				.role("ROLE_USER")
				.build();

	}

	// Entity -> DTO
	public static UserDto toDto(User user){
		return UserDto.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.role(user.getRole())
				.build();
	}

}
