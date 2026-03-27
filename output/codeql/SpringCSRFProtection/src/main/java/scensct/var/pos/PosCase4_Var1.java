// A Spring Security WebFlux configuration that calls csrf(ServerHttpSecurity.CsrfSpec::disable) using a method reference should be flagged as disabling CSRF protection.
package scensct.var.pos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class PosCase4_Var1 {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        // Variant 1: Use method reference directly
        return http.csrf(ServerHttpSecurity.CsrfSpec::disable).build(); // [REPORTED LINE]
    }
}