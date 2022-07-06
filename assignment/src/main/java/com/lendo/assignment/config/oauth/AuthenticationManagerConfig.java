package com.lendo.assignment.config.oauth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;

@Configuration
public class AuthenticationManagerConfig extends GlobalAuthenticationConfigurerAdapter {
    @Value("${user.authentication.username}")
    private String userName;
    @Value("${user.authentication.password}")
    private String password;
    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(userName).password(password).roles("USER");
    }
}
