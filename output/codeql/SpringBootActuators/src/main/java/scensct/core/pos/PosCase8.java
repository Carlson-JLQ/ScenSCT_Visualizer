// Scenario 8: HttpSecurity.requestMatchers("/actuator/**").authorize().requestMatchers("/**").permitAll() direct chain should be flagged as unauthenticated actuator access.
package scensct.core.pos;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class PosCase8 {
    public void configure(HttpSecurity http) throws Exception {
        // Single request matcher, authorize no-arg, nested requestMatchers with wildcard, permitAll chain
        http.requestMatchers("/actuator/**").authorize().requestMatchers("/**").permitAll();
    }
}