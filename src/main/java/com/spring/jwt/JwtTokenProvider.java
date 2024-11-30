package com.spring.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenProvider {
	
	
	@Value("${app.jwt-secret}")
	private String secretKey;
	
	@Value("${app-jwt-expiration-milliseconds}")
	private String jwtExpirationDate;
	
	private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000;
	
	// generate JWT Token
	
	public String generateToken(Authentication authentication)
	{
		
		String username = authentication.getName();

        Date currentDate = new Date();
       
        @SuppressWarnings("deprecation")
		String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(key())
                .compact();
        return token;
        
        
        
       
	}
	
	private Key key()
	{
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
	}
    
    
 // get username from Jwt token
    public String getUsername(String token)
	{
		Claims claims = Jwts.parser()
		.setSigningKey(key())
		.build()
		.parseClaimsJws(token)
		.getBody();
		String username = claims.getSubject();
		
		return username;
	}
    
 // validate Jwt token
    public boolean validateToken(String token){
    	try{
    		Jwts.parser()
    		.setSigningKey(key())
    		.build()
    		.parse(token);
    		
    		return true;
    		}
    	catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }


}
