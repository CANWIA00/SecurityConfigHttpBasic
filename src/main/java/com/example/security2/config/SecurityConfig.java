package com.example.security2.config;

import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.httpBasic();
        httpSecurity.formLogin();
        httpSecurity
                .authorizeHttpRequests().requestMatchers("/dashboard").hasAnyRole("admin","user")
                .and()
                .authorizeHttpRequests().requestMatchers("/admin").hasAnyRole("admin")
                .and()
                .authorizeHttpRequests().requestMatchers("/index").permitAll();
        return httpSecurity.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}12345").roles("admin")
                .and()
                .withUser("user").password("{noop}12345").roles("user");
    }
}
