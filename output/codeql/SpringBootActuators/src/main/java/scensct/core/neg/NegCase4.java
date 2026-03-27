// permitAll() with both matcher-based and variable-based authorizeCall qualifiers but not linked via any actuator endpoint patterns should not be flagged as actuator endpoint vulnerability.
package scensct.core.neg;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class NegCase4 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Scenario: permitAll exists with both matcher-based and variable-based authorizeCall qualifiers
        // but not linked via lambda/zero-arg/anyRequest or shared variable patterns to actuator endpoints
        var requests = http.authorizeRequests(); // Variable access qualifier
        requests.antMatchers("/admin/**").hasRole("ADMIN"); // Matcher-based authorization
        http.authorizeRequests().permitAll(); // Unrelated permitAll not configured for actuator endpoints
    }
}