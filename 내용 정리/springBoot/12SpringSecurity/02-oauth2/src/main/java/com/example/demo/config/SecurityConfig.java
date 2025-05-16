package com.example.demo.config;

import com.example.demo.config.auth.exceptionHandler.CustomAccessDeniedHandler;
import com.example.demo.config.auth.exceptionHandler.CustomAuthenticationEntryPoint;
import com.example.demo.config.auth.loginHandler.CustomLoginFailureHandler;
import com.example.demo.config.auth.loginHandler.CustomLoginSuccessHandler;
import com.example.demo.config.auth.logoutHandler.CustomLogoutHandler;
import com.example.demo.config.auth.logoutHandler.CustomLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomLoginSuccessHandler customLoginSuccessHandler;

    @Autowired
    private CustomLogoutHandler customLogoutHandler;

    @Autowired
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        // CSRF 비활성화
        http.csrf((config)->{config.disable();}); // csrf 토큰값확인x , get /logout 처리 가능

        // CSRF토큰을 쿠키형태로 전환
//		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

        // 권한체크
        http.authorizeHttpRequests((auth)->{ auth
                    .requestMatchers("/","/join","/login").permitAll()
                    .requestMatchers("/user").hasRole("USER")
                    .requestMatchers("/manager").hasRole("MANAGER")
                    .requestMatchers("/admin").hasRole("ADMIN")
                    .anyRequest().authenticated();
        });

        // 로그인
        http.formLogin((login)->{ login
                .permitAll()
                .loginPage("/login")
                .successHandler(customLoginSuccessHandler)
                .failureHandler(new CustomLoginFailureHandler());
        });

        // 로그아웃
        http.logout((logout)->{ logout
                    .permitAll()
                    .addLogoutHandler(customLogoutHandler)
                    .logoutSuccessHandler(customLogoutSuccessHandler);
        });

        // 예외처리
        http.exceptionHandling((exception)->{
            exception.authenticationEntryPoint(new CustomAuthenticationEntryPoint());
            exception.accessDeniedHandler(new CustomAccessDeniedHandler());
        });
        http.oauth2Login((oauth2)->{
           oauth2.loginPage("/login");
        });
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
