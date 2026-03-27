package org.springframework.security.config.annotation.web.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public abstract class WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception {}
}