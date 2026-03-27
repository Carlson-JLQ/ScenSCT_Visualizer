// Scenario 3: HttpSecurity.requestMatchers("/actuator/**").authorize lambda with requestMatchers("/**").permitAll() should be flagged as unauthenticated actuator access.
package scensct.core.pos;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class PosCase3 {
    public void configure(HttpSecurity http) throws Exception {
        // Single request matcher, authorize lambda, nested requestMatchers permitAll
        http.requestMatchers("/actuator/**").authorize(auth -> auth.requestMatchers("/**").permitAll());
    }
}