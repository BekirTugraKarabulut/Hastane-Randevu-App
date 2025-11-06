package com.tugra.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "ebJzw8bO7/yzXbyfMdEd5iwxbKrwNbNXOU8boPJf5zE=";

    public String generateToken(UserDetails userDetails) {

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getKey() , SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims getClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T exportToken(String token, Function<Claims,T> claimsFunction){
        Claims claims = getClaims(token);
        return claimsFunction.apply(claims);
    }

    public String getUsernameByToken(String token){
        return exportToken(token, Claims::getSubject);
    }

    public boolean isExpireToken(String token){
        return new Date().before(getClaims(token).getExpiration());
    }

    public Key getKey(){
        byte[] encodedKey = Base64.getDecoder().decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(encodedKey);
    }

}
