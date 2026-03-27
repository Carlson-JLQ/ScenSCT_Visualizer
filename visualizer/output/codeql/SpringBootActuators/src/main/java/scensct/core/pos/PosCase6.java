// Scenario 6: HttpSecurity.authorize().requestMatchers("/actuator/**").permitAll() direct chain should be flagged as unauthenticated actuator access.
package scensct.core.pos;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class PosCase6 {
    public void configure(HttpSecurity http) throws Exception {
        // Authorize no-arg, requestMatchers with actuator path, permitAll chain
        http.authorize().requestMatchers("/actuator/**").permitAll();
    }
}