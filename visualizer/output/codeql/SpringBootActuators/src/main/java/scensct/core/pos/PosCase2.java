// Scenario 2: HttpSecurity.requestMatchers().authorize lambda with anyRequest().permitAll() should be flagged as unauthenticated actuator access.
package scensct.core.pos;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class PosCase2 {
    public void configure(HttpSecurity http) throws Exception {
        // Request matchers registry, authorize lambda, anyRequest permitAll
        http.requestMatchers().authorize(auth -> auth.anyRequest().permitAll());
    }
}