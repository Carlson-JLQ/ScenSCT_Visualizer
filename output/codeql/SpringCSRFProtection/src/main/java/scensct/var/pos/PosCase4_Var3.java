// A Spring Security WebFlux configuration that calls csrf(ServerHttpSecurity.CsrfSpec::disable) using a method reference should be flagged as disabling CSRF protection.
package scensct.var.pos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class PosCase4_Var3 {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        // Variant 3: Use a helper method that returns the lambda
        return http.csrf(makeCsrfDisabler()).build();
    }

    private static java.util.function.Consumer<ServerHttpSecurity.CsrfSpec> makeCsrfDisabler() {
        return csrf -> csrf.disable(); // [REPORTED LINE]
    }
}