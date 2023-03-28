//package com.example.demo.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.authentication.logout.LogoutHandler;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import lombok.RequiredArgsConstructor;
//
//
//
//
//@Configuration
//@EnableWebMvcSecurity
//@EnableWebMvc
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@RequiredArgsConstructor
//public class SecurityConfig {
//		
//	@Autowired
//	 private JwtAuthenticationFilter jwtAuthFilter;
//	
//	// AuthenticationProvider authenticationProvider;
////	@Autowired
////	private AuthenticationEntryPoint authenticationEntryPoint;
//	
//	private  final AuthenticationEntryPoint authenticationEntryPoint;
//	
//	@Autowired
////	 private JwtAuthenticationEntryPoint unauthorizedHandler;
//	 LogoutHandler logoutHandler;
//	
//	
//	
////	  @Bean
////	  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////	    http
////	        .csrf()
////	        .disable()
////	        .authorizeHttpRequests()
////	        .requestMatchers("/api/v1/auth/**")
////	          .permitAll()
////	        .anyRequest()
////	          .authenticated()
////	        .and()
////	          .sessionManagement()
////	          .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////	        .and()
////	        .authenticationProvider(authenticationProvider)
////	        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
////	        .logout()
////	        .logoutUrl("/api/v1/auth/logout")
////	        .addLogoutHandler(logoutHandler)
////	        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
////	    ;
////
////	    return http.build();
////	  }
//	 
//	 @Bean
//	  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	    http
//	        .csrf()
//	        .disable()
//	        .authorizeHttpRequests()
//	        .requestMatchers("/api/v1/auth/**")
//	          .permitAll()
//	        .anyRequest()
//	          .authenticated()
//	        .and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
//	          .and()
//	          .sessionManagement()
//	          .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//	        .and()
//	        .addFilterBefore(this.jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//	        
//	        
//	    ;
//
//	    return http.build();
//	  }
//	}
