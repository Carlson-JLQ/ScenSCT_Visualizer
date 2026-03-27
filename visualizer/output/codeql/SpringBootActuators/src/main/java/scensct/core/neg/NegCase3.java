// permitAll() with authorizeCall qualifier as variable access but not linked via lambda/zero-arg/shared variable patterns should not be flagged as actuator endpoint vulnerability.
package scensct.core.neg;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class NegCase3 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Scenario: permitAll exists with authorizeCall having variable access qualifier
        // but not linked via lambda/zero-arg/shared variable patterns to actuator endpoints
        var requests = http.authorizeRequests(); // Variable access qualifier
        requests.antMatchers("/api/**").authenticated(); // Different authorization chain
        http.authorizeRequests().permitAll(); // Unrelated permitAll call
    }
}