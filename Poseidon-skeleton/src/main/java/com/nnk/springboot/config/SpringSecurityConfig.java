package com.nnk.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Configuration class for Spring Security, enabling and customizing web security for the poseidon application.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    public SpringSecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    /**
     * Configures the SecurityFilterChain to specify security settings like which paths are secured,
     * the form login configuration, remember me functionality, and logout behavior.
     *
     * @param http HttpSecurity used to configure the security filter chain.
     * @return the configured SecurityFilterChain object.
     * @throws Exception if an error occurs during configuration.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/user/**", "/").hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //.defaultSuccessUrl("/bidList/list", true)
                .successHandler(customAuthenticationSuccessHandler())
                .permitAll()
                .and()
                .rememberMe()
                .rememberMeParameter("remember-me")
                .tokenValiditySeconds(86400) // 86400 seconds = 24 hours
                .and()
                .logout()
                .logoutUrl("/app-logout")
                .logoutSuccessUrl("/login?logout=true")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");
        return http.build();
    }

    /**
     * Defines the bean for password encoding using BCrypt hashing algorithm.
     *
     * @return a BCryptPasswordEncoder instance.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Constructs a CustomAuthenticationSuccessHandler bean.
     *
     * @return an instance of CustomAuthenticationSuccessHandler.
     */
    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    /**
     * Configures and returns an AuthenticationManager using the custom user details service
     * and password encoder to support authentication processes.
     *
     * @param http the HttpSecurity object providing context for configuration.
     * @param bCryptPasswordEncoder the BCryptPasswordEncoder for encoding passwords.
     * @return the configured AuthenticationManager instance.
     * @throws Exception if an error occurs during configuration.
     */
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
        return authenticationManagerBuilder.build();
    }

}
