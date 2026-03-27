// A Spring Security WebFlux configuration that directly calls csrf().disable() on ServerHttpSecurity.CsrfSpec should be flagged as disabling CSRF protection.
package scensct.var.pos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class PosCase2_Var5 {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        // Variant 5: Use a conditional that always evaluates to true, but structure differently
        boolean enableSecurity = true;
        ServerHttpSecurity.CsrfSpec csrfSpec = http.csrf();
        if (enableSecurity) {
            csrfSpec.disable(); // [REPORTED LINE]
        }
        // The disable call is reachable and executed; build after the condition
        return http.build();
    }
}