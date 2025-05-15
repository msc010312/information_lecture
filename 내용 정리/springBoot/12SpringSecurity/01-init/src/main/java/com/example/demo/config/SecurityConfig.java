package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        // CSRF 비활성화
//      http.csrf().disable(); // csrf 토큰값확인x , get /logout 처리 가능
        http.csrf((config)->{config.disable();});

        // CSRF토큰을 쿠키형태로 전환
//		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

        // 권한체크
        http.authorizeHttpRequests((auth)->{ auth
                    .requestMatchers("/","/join","/login").permitAll()
                    .requestMatchers("/user").hasRole("USER")
                    .requestMatchers("/manager").hasRole("MANAGER")
                    .requestMatchers("/admin").hasRole("ADMIN")
                    .anyRequest().authenticated();
                    //.permitAll();

        });

        // 로그인
        http.formLogin((login)->{ login
                .permitAll()
                .loginPage("/login");
//                .successHandler(new CustomLoginSuccessHandler()) // 로그인 성공 시 핸들러 처리
//                .failureHandler(new CustomLoginFailureHandler()); // 로그인 실패 시 핸들러 처리
        });

        // 로그아웃
        http.logout((logout)->{ logout
                .permitAll();
//                .addLogoutHandler(new CustomLogoutHandler()) // 로그아웃시 핸들러 처리
//                .logoutSuccessHandler(new CustomLogoutSuccessHandler()); // 로그아웃 성공 시 핸들러 처리
        });

        // 예외처리
        http.exceptionHandling((exception)->{
//                .authenticationEntryPoint(new CustomAuthenticationEntryPoint()) // 미 인증 계정 예외처리
//                .accessDeniedHandler(new CustomAccessDeniedHandler()); // 권한부족 예외처리
        });

        // remember me
        http.rememberMe((remember)->{ remember
                .key("rememberMeKey")
                .rememberMeParameter("remember-me") // 받아올 name 작성
                .alwaysRemember(false) // 항상 remember me 활성화 여부
                .tokenValiditySeconds(60*60); // 로그인 상태 유지시간
        }); // 로그인 상태 유지

        return http.build();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("1234")).roles("USER");
//		auth.inMemoryAuthentication().withUser("manager").password(passwordEncoder.encode("1234")).roles("MANAGER");
//		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("1234")).roles("ADMIN");
//        auth.userDetailsService(principalDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
