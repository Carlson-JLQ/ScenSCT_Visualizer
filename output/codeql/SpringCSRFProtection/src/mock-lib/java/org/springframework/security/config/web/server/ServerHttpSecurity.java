package org.springframework.security.config.web.server;

import org.springframework.security.web.server.SecurityWebFilterChain;
import java.util.function.Consumer;

public class ServerHttpSecurity {
    public org.springframework.security.config.web.server.ServerHttpSecurity.CsrfSpec csrf() { return null; }
    public ServerHttpSecurity csrf(Consumer<CsrfSpec> csrfCustomizer) { return null; }
    public SecurityWebFilterChain build() { return null; }
    public static class CsrfSpec {
        public ServerHttpSecurity disable() { return null; }
    }
}