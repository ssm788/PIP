package com.example.demo.aop;

import java.net.URLDecoder;
import java.security.Key;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class CheckAccessImplementor {
	public static final String SECRET = "4428472B4B6250655368566D5971337436763979244226452948404D63516654";
	//public static final String SECRET = "1128472B4B6250655368566D5471337436763979244226452948404D63516654";
	 
	
	@Around("execution(@com.example.demo.aop.CheckAccess * *(..)) && @annotation(checkAccess)")
	public Object checkAccessAdvice(ProceedingJoinPoint proceedingJoinPoint, CheckAccess checkAccess) throws Throwable {
		try {
			System.out.println("hiiidsfdsfffsd");
			Object[] signatureArgs = proceedingJoinPoint.getArgs();
			System.out.println("signatureArgs"+proceedingJoinPoint.getArgs().length);
			CodeSignature methodSignature = (CodeSignature) proceedingJoinPoint.getSignature();

			HttpServletRequest req = (HttpServletRequest) signatureArgs[0];
			
			String reqUrl = req.getRequestURL().toString();
			
			System.out.println("Authprization"+ req.getHeader("Authorization"));
			
			Object returnValue = null;
			Claims claims=Jwts
	        .parserBuilder()
	        .setSigningKey(getSignKey())
	        .build()
	        .parseClaimsJws(req.getHeader("Authorization"))
	        .getBody();
			System.out.println("claims"+ claims);
			returnValue = proceedingJoinPoint.proceed();
			return returnValue;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	
	private Key getSignKey() {
		// TODO Auto-generated method stub
		byte [] keyBytes=Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
