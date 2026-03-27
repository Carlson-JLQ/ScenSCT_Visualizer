// Scenario 7: HttpSecurity.requestMatchers().authorize().requestMatchers("/actuator/**").permitAll() direct chain should be flagged as unauthenticated actuator access.
package scensct.core.pos;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class PosCase7 {
    public void configure(HttpSecurity http) throws Exception {
        // Request matchers registry, authorize no-arg, nested requestMatchers with actuator path, permitAll chain
        http.requestMatchers().authorize().requestMatchers("/actuator/**").permitAll();
    }
}