// A Spring Security WebFlux configuration that calls csrf(ServerHttpSecurity.CsrfSpec::disable) using a method reference should be flagged as disabling CSRF protection.
package scensct.core.pos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class PosCase4 {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http.csrf(csrf -> csrf.disable()).build(); // Method reference style call to disable CSRF protection in WebFlux // [REPORTED LINE]
    }
}