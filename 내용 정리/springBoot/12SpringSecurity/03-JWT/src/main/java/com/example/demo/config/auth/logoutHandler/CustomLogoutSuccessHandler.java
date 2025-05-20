package com.example.demo.config.auth.logoutHandler;

import com.example.demo.config.auth.PrincipalDetails;
import com.example.demo.config.auth.jwt.JwtProperties;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

@Slf4j
@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	@Value("${spring.security.oauth2.client.registration.kakao.client-id}")
	String KAKAO_CLIENT_ID;
	@Value("${spring.security.oauth2.client.kakao.logout.redirect.uri}")
	String KAKAO_LOGOUT_REDIRECT_URI;



	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		log.info("CustomLogoutSuccessHandler onLogoutSuccess invoke.." + authentication);

		// JWT 토큰 가져오기
		String token = Arrays.stream(request.getCookies())
				.filter(cookie -> cookie.getName().equals(JwtProperties.ACCESS_TOKEN_COOKIE_NAME)).findFirst()
				.map(cookie -> cookie.getValue())
				.orElse(null);

		Cookie cookie = new Cookie(JwtProperties.ACCESS_TOKEN_COOKIE_NAME, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);

		PrincipalDetails principalDetails = (PrincipalDetails)authentication.getPrincipal();
		String provider = principalDetails.getUserDto().getProvider();
		if(provider!=null && provider.startsWith("kakao")){
			response.sendRedirect("https://kauth.kakao.com/oauth/logout?client_id="+KAKAO_CLIENT_ID+"&logout_redirect_uri="+KAKAO_LOGOUT_REDIRECT_URI);
			return ;
		}else if(provider!=null && provider.startsWith("naver")){
			//https://nid.naver.com/nidlogin.logout?returl=https://www.naver.com/
			response.sendRedirect("https://nid.naver.com/nidlogin.logout?returl=https://www.naver.com/");
			return ;
		}else if(provider!=null && provider.startsWith("google")){
			response.sendRedirect("https://accounts.google.com/Logout");
			return ;
		}

		response.sendRedirect(request.getContextPath()+"/");
	}

}
