package com.gyuwangsa.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

// 스프링 시큐리티 필터나 서비스에서 jwt 생성, 검증, 설정을 관리하는 class
@Component
@PropertySource("classpath:config/jwt.properties")
public class JwtConfig {
    //비밀키
    @Value("${jwt.secret}")
    private String secret ;
    //토큰 만료 시간
    @Value("${jwt.expiration}")
    private long expiration ;
    //헤더 이름
    @Value("${jwt.header}")
    private String header;
    //접두사
    @Value("${jwt.prefix}")
    private String prefix;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
