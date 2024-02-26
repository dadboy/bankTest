//package com.example.banktest.service;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // Aquí puedes establecer información estática del usuario
//        return org.springframework.security.core.userdetails.User
//                .withUsername(username)
//                .password("password") // Puedes definir una contraseña (no se utilizará en este contexto)
//                .authorities("ROLE_USER") // Puedes establecer roles o autoridades según tus necesidades
//                .accountExpired(false)
//                .accountLocked(false)
//                .credentialsExpired(false)
//                .disabled(false)
//                .build();
//    }
//}