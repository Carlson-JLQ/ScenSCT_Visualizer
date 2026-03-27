// A Spring Security WebFlux configuration that directly calls csrf().disable() on ServerHttpSecurity.CsrfSpec should be flagged as disabling CSRF protection.
package scensct.var.pos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class PosCase2_Var4 {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        // Variant 4: Wrap in a try-catch block but ensure disable call is always executed
        try {
            // Simulate some configuration that might throw, but doesn't affect CSRF
            return http.csrf().disable().build(); // [REPORTED LINE]
        } catch (Exception e) {
            // Re-throw to keep the method simple; the disable call is already made
            throw new RuntimeException(e);
        }
    }
}