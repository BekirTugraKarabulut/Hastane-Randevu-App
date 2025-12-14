package com.tugra.config;

import com.tugra.jwt.AuthEntryPoint;
import com.tugra.jwt.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String REGISTER = "/register";
    private static final String LOGIN = "/login";
    private static final String REFRESH_TOKEN = "/refresh_token";

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private AuthEntryPoint authEntryPoint;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.csrf((csrf) -> csrf.disable())
                                .authorizeHttpRequests((request) -> request
                                .requestMatchers(
                                        REGISTER ,
                                        LOGIN ,
                                        REFRESH_TOKEN,
                                        "/calisanlar/**",
                                        "/bolum/**",
                                        "/rest/api/countKullanici",
                                        "/departman/departman-ekle",
                                        "/hastane/**",
                                        "/swagger-ui/**",
                                        "/v3/api-docs/**",
                                        "/swagger.html")
                                .permitAll()
                                .anyRequest()
                                .authenticated())
                .exceptionHandling((csrf) -> csrf.authenticationEntryPoint(authEntryPoint))
                .authenticationProvider(authenticationProvider)
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter , UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
