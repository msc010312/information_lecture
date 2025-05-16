package com.example.demo.config.auth;

import com.example.demo.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrincipalDetails implements UserDetails{
	private UserDto userDto;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection <GrantedAuthority> authority = new ArrayList();
		authority.add(new SimpleGrantedAuthority(userDto.getRole()));
		return authority;
	}

	@Override
	public String getPassword() {
		return userDto.getPassword();
	}

	@Override
	public String getUsername() {
		return userDto.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
