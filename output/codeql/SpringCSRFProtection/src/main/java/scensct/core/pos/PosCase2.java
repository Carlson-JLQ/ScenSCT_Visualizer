// A Spring Security WebFlux configuration that directly calls csrf().disable() on ServerHttpSecurity.CsrfSpec should be flagged as disabling CSRF protection.
package scensct.core.pos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class PosCase2 {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http.csrf().disable().build(); // Direct call to disable CSRF protection in WebFlux // [REPORTED LINE]
    }
}