//package com.example.demo.security;
//
//
//import com.example.demo.repository.CameraRepository;
//import com.example.demo.service.JwtService;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.security.Security;
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.lang.NonNull;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//@Component
//@RequiredArgsConstructor
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//	@Autowired
//	 JwtService jwtService;
//	@Autowired
//	 UserDetailsService userDetailsService;
//	@Autowired
//	 CameraRepository tokenRepository;
//
//  @Override
//  protected void doFilterInternal(
//      @NonNull HttpServletRequest request,
//      @NonNull HttpServletResponse response,
//      @NonNull FilterChain filterChain
//  ) throws ServletException, IOException {
//    final String authHeader = request.getHeader("Authorization");
//    final String jwt;
//    final String userEmail;
//    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
//      filterChain.doFilter(request, response);
//      return;
//    }
//    System.out.println("authHeader "+authHeader);
//    jwt = authHeader.substring(7);
//    System.out.println("token "+jwt);
//    userEmail = jwtService.extractUsername(jwt);
//    if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//      UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
////      var isTokenValid = tokenRepository.findByToken(jwt)
////          .map(t -> !t.isExpired() && !t.isRevoked())
////          .orElse(false);
//      if (jwtService.isTokenValid(jwt, userDetails)) {
//        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
//            userDetails,
//            null,
//            userDetails.getAuthorities()
//        );
//        authToken.setDetails(
//            new WebAuthenticationDetailsSource().buildDetails(request)
//        );
//        SecurityContextHolder.getContext().setAuthentication(authToken);
//      }
//    }
//    filterChain.doFilter(request, response);
//  }
//}
