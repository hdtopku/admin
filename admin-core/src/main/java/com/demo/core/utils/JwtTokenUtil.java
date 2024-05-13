package com.demo.core.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Map;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-12 17:48:02
 */
public class JwtTokenUtil {
    private static final String JWT_SECRET = "404E635266556ADF6586E3272357538782F413F4428472B4B6250645367566B5978BAD";
    public static final int JWT_TOKEN_EXPIRATION_SECONDS = 60; // 30 minutes

    private JwtTokenUtil() {
    }

    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder().claims(claims).signWith(getSigningKey()).compact();
    }

    public static Claims parseToken(String token) {
        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload();
    }

    private static SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(JWT_SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
