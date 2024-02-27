package com.example.banktest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
/**
*
* @author despinoza
*
*/
@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
			"/api-docs",
            "/v2/api-docs", 
            "/swagger-resources/**", 
            "/configuration/ui",
            "/configuration/security", 
            "/swagger-ui.html",
            "/webjars/**"
    };
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Desactivar CSRF y configurar el filtro de autenticación JWT
		http.csrf().disable()
				.addFilterAfter(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				// Permitir acceso sin autenticación a estas rutas específicas
				.antMatchers(AUTH_WHITELIST)
				.permitAll()
				// Permitir acceso sin autenticación a las rutas de inicio de sesión y creación
				// de usuario
				.antMatchers(HttpMethod.POST, "/api/v1/login").permitAll()
				.antMatchers(HttpMethod.POST, "/api/v1/user").permitAll()
				// Resto de las rutas requieren autenticación
				.anyRequest().authenticated();
	}
}