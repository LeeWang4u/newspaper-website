//package com.ptit.Security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        //define query to retrieve user by username
//        jdbcUserDetailsManager.setUsersByUsernameQuery(
//                "select Email, pass_word "
//                        + "from user "
//                        + "where Email = ?");
//        //define query to retrieve roles by username
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
//                "select Email, Role "
//                        + "from user "
//                        + "where Email = ?");
//        return jdbcUserDetailsManager;
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(configurer ->
//                        configurer
//                                .requestMatchers("/").hasRole("USER")
//                                .requestMatchers("/admin/**").hasRole("ADMIN")
//                                .anyRequest().authenticated()
//                )
//
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .loginProcessingUrl("/authenticateTheUser")
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .permitAll()
//                );
////                .exceptionHandling(configuer -> configuer
////                        .accessDeniedPage("/access-denied")
////                );
//        return http.build();
//    }
//}