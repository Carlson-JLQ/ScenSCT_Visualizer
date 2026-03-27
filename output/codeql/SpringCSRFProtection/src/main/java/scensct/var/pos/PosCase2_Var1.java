// A Spring Security WebFlux configuration that directly calls csrf().disable() on ServerHttpSecurity.CsrfSpec should be flagged as disabling CSRF protection.
package scensct.var.pos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class PosCase2_Var1 {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        // Variant 1: Split chain into local variables
        ServerHttpSecurity.CsrfSpec csrf = http.csrf();
        ServerHttpSecurity builder = csrf.disable(); // [REPORTED LINE]
        return builder.build();
    }
}