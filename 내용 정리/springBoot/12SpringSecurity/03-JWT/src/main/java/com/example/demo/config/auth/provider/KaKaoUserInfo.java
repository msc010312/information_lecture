package com.example.demo.config.auth.provider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KaKaoUserInfo implements Oauth2UserInfo{
    private Long id;
    private LocalDateTime connected_at;
    private Map<String,Object> properties;
    private Map<String,Object> kakao_account;

    @Override
    public String getName() {
        return (String)properties.get("nickname");
    }

    @Override
    public String getEmail() {
        return (String)properties.get("email");
    }

    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getProviderId() {
        return id+"";
    }

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }
}
