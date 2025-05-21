package com.example.demo.config.auth.jwt;


import com.example.demo.domain.entity.JwtToken;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.JwtTokenRepository;
import com.example.demo.domain.repository.UserRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

/**
 * JWT를 이용한 인증
 */
@Component
@AllArgsConstructor
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtTokenRepository jwtTokenRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException, IOException {
        System.out.println("[JWTAUTHORIZATIONFILTER] doFilterInternal...");

        // cookie 에서 JWT token을 가져옵니다.
        String token = null;
        try {
            token = Arrays.stream(request.getCookies())
                    .filter(cookie -> cookie.getName().equals(JwtProperties.ACCESS_TOKEN_COOKIE_NAME)).findFirst()
                    .map(cookie -> cookie.getValue())
                    .orElse(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (token != null) {
            try {
                if(jwtTokenProvider.validateToken(token)) {
                    Authentication authentication = getUsernamePasswordAuthenticationToken(token);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    System.out.println("[JWTAUTHORIZATIONFILTER] : " + authentication);
                }

            } catch (ExpiredJwtException e)     //토큰만료시 예외처리(쿠키 제거)
            {
                //토큰 만료시
                JwtToken jwtToken = jwtTokenRepository.findByAccessToken(token);
                if(jwtToken!=null){
                    String refreshToken = jwtToken.getRefreshToken();
                    try {
                        if(jwtTokenProvider.validateToken(refreshToken)) {
                            //accessToken 만료, refreshToken 만료x -> access-token 갱신
                            long now = (new Date()).getTime();
                            User user = userRepository.findByUsername(jwtToken.getUsername());
                            Date accessTokenExpiresIn = new Date(now + JwtProperties.ACCESS_TOKEN_EXPIRATION_TIME); // 60초후 만료
                            String accessToken = Jwts.builder()
                                    .setSubject(jwtToken.getUsername())
                                    .claim("username",jwtToken.getUsername()) //정보저장
                                    .claim("auth", user.getRole())//정보저장
                                    .setExpiration(accessTokenExpiresIn)
                                    .signWith(jwtTokenProvider.getKey(), SignatureAlgorithm.HS256)
                                    .compact();

                            Cookie cookie = new Cookie(JwtProperties.ACCESS_TOKEN_COOKIE_NAME,accessToken);
                            cookie.setMaxAge(JwtProperties.ACCESS_TOKEN_EXPIRATION_TIME);
                            cookie.setPath("/");
                            response.addCookie(cookie);
                            //DB 갱신된 accessToken 저장
                            jwtToken.setAccessToken(accessToken);
                            jwtTokenRepository.save(jwtToken);
                        }
                    } catch (ExpiredJwtException refreshTokenExpiredException){
                        // 엑세스 토큰 만료 o, 리프레시 토큰 만료 o
                        // 클라이언트 만료된 AccessToken 삭제
                        Cookie cookie = new Cookie(JwtProperties.ACCESS_TOKEN_COOKIE_NAME,null);
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                        // DB에 해당 token제거
                        jwtTokenRepository.deleteById(jwtToken.getId());
                    }
                }

                System.out.println("[JWTAUTHORIZATIONFILTER] : ...ExpiredJwtException ...."+e.getMessage());
            }catch(Exception e2){
                //그외 나머지
            }
        }
        chain.doFilter(request, response);
    }

    // TOKEN -> AUTHENTICATION 변환
    private Authentication getUsernamePasswordAuthenticationToken(String token) {
        Authentication authentication = jwtTokenProvider.getAuthentication(token);
        Optional<User> user = userRepository.findById(authentication.getName()); // 유저를 유저명으로 찾습니다.
        System.out.println("JwtAuthorizationFilter.getUsernamePasswordAuthenticationToken...authenticationToken : " +authentication );
        if(user.isPresent())
            return authentication;
        return null; // 유저가 없으면 NULL
    }

}