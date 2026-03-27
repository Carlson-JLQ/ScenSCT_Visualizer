// Scenario 5: HttpSecurity.requestMatchers().authorize().anyRequest().permitAll() direct chain should be flagged as unauthenticated actuator access.
package scensct.core.pos;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class PosCase5 {
    public void configure(HttpSecurity http) throws Exception {
        // Request matchers registry, authorize no-arg, anyRequest permitAll chain
        http.requestMatchers().authorize().anyRequest().permitAll();
    }
}