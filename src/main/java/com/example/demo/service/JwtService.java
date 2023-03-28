package com.example.demo.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
//  @Value("${jwt.secret}")
//  private String secret;
//  @Value("${app.jwttoken.message}")
//  private String message;
	
	public static final String SECRET = "4428472B4B6250655368566D5971337436763979244226452948404D63516654";
 public String generateToken(String userName) {
	 
	 Map<String,Object> claims=new HashMap<>();
	 return createToken(claims,userName);
 }

private String createToken(Map<String, Object> claims, String userName) {
	// TODO Auto-generated method stub
	return Jwts.builder()
			.setClaims(claims)
			.setSubject(userName)
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
			.signWith(getSignKey(),SignatureAlgorithm.HS256).compact();
}

private Key getSignKey() {
	// TODO Auto-generated method stub
	byte [] keyBytes=Decoders.BASE64.decode(SECRET);
	return Keys.hmacShaKeyFor(keyBytes);
}
public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }
public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

private Claims extractAllClaims(String token) {
    return Jwts
        .parserBuilder()
        .setSigningKey(getSignKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }
//public boolean isTokenValid(String token, UserDetails userDetails) {
//    final String username = extractUsername(token);
//    return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
//  }
private boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }
private Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }
//private Key getSignInKey() {
//    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
//    return Keys.hmacShaKeyFor(keyBytes);
//  }
}
