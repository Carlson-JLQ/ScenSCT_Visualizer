// A Spring Security WebFlux configuration that directly calls csrf().disable() on ServerHttpSecurity.CsrfSpec should be flagged as disabling CSRF protection.
package scensct.var.pos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class PosCase2_Var3 {
    // Variant 3: Extract non-core logic to a helper method, but keep disable call in main flow
    private ServerHttpSecurity configureCsrf(ServerHttpSecurity http) {
        // Helper that does nothing but return the same object; could be used for other configs
        return http;
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        ServerHttpSecurity configured = configureCsrf(http);
        return configured.csrf().disable().build(); // [REPORTED LINE]
    }
}