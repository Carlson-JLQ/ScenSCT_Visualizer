// A Spring Security MVC configuration that calls csrf(AbstractHttpConfigurer::disable) using a method reference should be flagged as disabling CSRF protection.
package scensct.core.pos;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class PosCase3 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()); // Method reference style call to disable CSRF protection
    }
}