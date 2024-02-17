package com.montreal.lms.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig{

    @Bean
    public JdbcUserDetailsManager userDetailManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/books/list").hasRole("EMPLOYEE")
                        .requestMatchers("/employees/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/employees/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .successHandler((request, response, authentication) -> response.sendRedirect("/books/list"))
                                .permitAll()
                )
                .logout(logout->logout.permitAll()
                )
                .exceptionHandling(configurer->
                        configurer
                                .accessDeniedPage("/employees/access-denied")
                );

        return http.build();
    }
}
