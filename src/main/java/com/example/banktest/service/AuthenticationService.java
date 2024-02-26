//package com.example.banktest.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import com.example.banktest.config.JwtTokenProvider;
//
//@Service
//public class AuthenticationService {
//
//    private final AuthenticationManager authenticationManager;
//    private final JwtTokenProvider jwtTokenProvider;
//
//    @Autowired
//    public AuthenticationService(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
//        this.authenticationManager = authenticationManager;
//        this.jwtTokenProvider = jwtTokenProvider;
//    }
//
//    public String authenticateAndGenerateToken(String username, String password) {
//        // Autenticación utilizando el AuthenticationManager
//    	UserDetails authenticationToken = new UserDetails(username, password);
//        authenticationManager.authenticate(authenticationToken);
//
//        // Generación del token JWT
//        return jwtTokenProvider.generateToken(authenticationToken);
//    }
//}