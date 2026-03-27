// Scenario 4: HttpSecurity.requestMatchers("/actuator/**").authorize().anyRequest().permitAll() direct chain should be flagged as unauthenticated actuator access.
package scensct.core.pos;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class PosCase4 {
    public void configure(HttpSecurity http) throws Exception {
        // Single request matcher, authorize no-arg, anyRequest permitAll chain
        http.requestMatchers("/actuator/**").authorize().anyRequest().permitAll();
    }
}