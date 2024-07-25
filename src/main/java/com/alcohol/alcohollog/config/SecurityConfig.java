package com.alcohol.alcohollog.config;

<<<<<<< Updated upstream
=======
import com.alcohol.alcohollog.config.jwt.JwtTokenFilter;
import com.alcohol.alcohollog.exception.CustomAuthenticationEntryPoint;
import com.alcohol.alcohollog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
>>>>>>> Stashed changes
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
<<<<<<< Updated upstream

@Configuration
@EnableWebSecurity
public class SecurityConfig {
=======
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserService userService;

    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    @Value("${jwt.token.secret}")
    private  String key;
>>>>>>> Stashed changes
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable);
        httpSecurity
                .authorizeRequests()
                .requestMatchers(
<<<<<<< Updated upstream
                        "/api/**"
                )
                .permitAll();
=======
                        "/",
                        "/swagger-ui/**",
                        "/swagger-ui.html",
                        "/api-docs/**",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/api/user/signup",
                        "/api/user/login"
                )
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling(handler -> handler.authenticationEntryPoint(customAuthenticationEntryPoint))
                .addFilterBefore(new JwtTokenFilter(userService, key), UsernamePasswordAuthenticationFilter.class);
>>>>>>> Stashed changes
        return httpSecurity.build();
    }
}
