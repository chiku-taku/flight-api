package com.example.demo.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

  @ApiModelProperty("盐")
  private static final String SALT_KEY = "jwtlingpaitaiduanbuxingzhegelingpaiyidingyaochangchangchangdecaibuhuibaocuo";

  @ApiModelProperty("令牌有效期毫秒")
  private static final long TOKEN_VALIDITY = 86400000;

  @ApiModelProperty("权限密钥")
  private static final String AUTHORITIES_KEY = "auth";

  @ApiModelProperty("Base64 密钥")
  private final static String SECRET_KEY =  Base64.getEncoder().encodeToString(SALT_KEY.getBytes(StandardCharsets.UTF_8));

    // 从令牌中提取用户名
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // 从令牌中提取过期时间
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // 提取单个声明
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // 生成令牌（不带额外声明）
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    // 生成令牌（带额外声明）
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 24小时有效期
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // 验证令牌
    public boolean isTokenValid(String token, String userId) {
        final String username = extractUsername(token);
        return (username.equals(userId)) && !isTokenExpired(token);
    }

    // 检查令牌是否过期
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // 提取所有声明
    public Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // 获取签名密钥
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}