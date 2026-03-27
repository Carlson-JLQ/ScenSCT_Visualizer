// permitAll() without authorizeCall qualifiers of HttpSecurityMatcherCall/HttpSecurityMatchersCall or variable access should not be flagged as actuator endpoint vulnerability.
package scensct.core.neg;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class NegCase1 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Scenario: permitAll exists but no authorizeCall with required qualifiers
        // This permitAll is not part of a request matcher authorization chain
        http.authorizeRequests().permitAll(); // Standalone permitAll not linked to actuator endpoints
    }
}