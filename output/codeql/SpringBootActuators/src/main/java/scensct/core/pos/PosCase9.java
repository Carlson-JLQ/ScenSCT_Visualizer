// Scenario 9: HttpSecurity used in both requestMatchers("/actuator/**") and authorize lambda with anyRequest().permitAll() should be flagged as unauthenticated actuator access.
package scensct.core.pos;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class PosCase9 {
    public void configure(HttpSecurity http) throws Exception {
        // Separate calls: requestMatchers with actuator path and authorize lambda with anyRequest permitAll
        http.requestMatchers("/actuator/**");
        http.authorize(auth -> auth.anyRequest().permitAll());
    }
}