package com.example.muhammad.newbie.security.websecurity;

import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(final AuthenticationManagerBuilder authManager)throws Exception {
        authManager.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder().encode("User1Pass")).roles("USER")
                .and()
                .withUser("user2").password(passwordEncoder().encode("User2Pass")).roles("USER")
                .and()
                .withUser("admin").password((passwordEncoder().encode("adminPass"))).roles("ADMIN");

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
