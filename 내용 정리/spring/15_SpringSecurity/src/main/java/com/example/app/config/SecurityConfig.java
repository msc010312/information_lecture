package com.example.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.example.app.config.auth.PrincipalDetailsService;
import com.example.app.config.auth.exceptionHandler.CustomAccessDeniedHandler;
import com.example.app.config.auth.exceptionHandler.CustomAuthenticationEntryPoint;
import com.example.app.config.auth.loginHandler.CustomLoginFailureHandler;
import com.example.app.config.auth.loginHandler.CustomLoginSuccessHandler;
import com.example.app.config.auth.logoutHandler.CustomLogoutHandler;
import com.example.app.config.auth.logoutHandler.CustomLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private PrincipalDetailsService principalDetailsService; 
	
	@Autowired
	private DataSource dataSource3;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// CSRF 비활성화
		http.csrf().disable(); // csrf 토큰값확인x , get /logout 처리 가능
		
		// CSRF토큰을 쿠키형태로 전환
//		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

		// 권한체크
		http.authorizeRequests()
			.antMatchers("/","/join","/login").permitAll()
			.antMatchers("/user").hasRole("USER")
			.antMatchers("/manager").hasRole("MANAGER")
			.antMatchers("/admin").hasRole("ADMIN")
			.anyRequest()
			//.permitAll();
			.authenticated();
		// 로그인
		http.formLogin()
			.loginPage("/login")
			.permitAll()
			.successHandler(new CustomLoginSuccessHandler()) // 로그인 성공 시 핸들러 처리
			.failureHandler(new CustomLoginFailureHandler()); // 로그인 실패 시 핸들러 처리
		// 로그아웃
		http.logout()
			.permitAll()
			.addLogoutHandler(new CustomLogoutHandler()) // 로그아웃시 핸들러 처리
			.logoutSuccessHandler(new CustomLogoutSuccessHandler()); // 로그아웃 성공 시 핸들러 처리
		// 예외처리
		http.exceptionHandling()
			.authenticationEntryPoint(new CustomAuthenticationEntryPoint()) // 미 인증 계정 예외처리
			.accessDeniedHandler(new CustomAccessDeniedHandler()); // 권한부족 예외처리
		// remember me
		http.rememberMe() // 로그인 상태 유지
			.key("rememberMeKey")
			.rememberMeParameter("remember-me") // 받아올 name 작성
			.alwaysRemember(false) // 항상 remember me 활성화 여부
			.tokenValiditySeconds(60*60) // 로그인 상태 유지시간
			.tokenRepository(tokenRepository());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("1234")).roles("USER");
//		auth.inMemoryAuthentication().withUser("manager").password(passwordEncoder.encode("1234")).roles("MANAGER");
//		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("1234")).roles("ADMIN");
		auth.userDetailsService(principalDetailsService).passwordEncoder(passwordEncoder);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PersistentTokenRepository tokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource3);
		return repo;
	}

}
