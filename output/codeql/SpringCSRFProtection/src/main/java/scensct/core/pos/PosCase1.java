// A Spring Security MVC configuration that directly calls csrf().disable() on CsrfConfigurer<HttpSecurity> should be flagged as disabling CSRF protection.
package scensct.core.pos;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class PosCase1 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // Direct call to disable CSRF protection
    }
}