// Scenario 1: HttpSecurity.authorize lambda with requestMatchers("/actuator/**").permitAll() should be flagged as unauthenticated actuator access.
package scensct.core.pos;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class PosCase1 {
    public void configure(HttpSecurity http) throws Exception {
        // Lambda with permitAll on actuator path
        http.authorize(auth -> auth.requestMatchers("/actuator/**").permitAll());
    }
}