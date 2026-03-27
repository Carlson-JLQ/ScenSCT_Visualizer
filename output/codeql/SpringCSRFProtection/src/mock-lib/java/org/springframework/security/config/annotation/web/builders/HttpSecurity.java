package org.springframework.security.config.annotation.web.builders;

import java.util.function.Consumer;

public class HttpSecurity {
    public CsrfConfigurer csrf() { return null; }
    public HttpSecurity csrf(Consumer<? super CsrfConfigurer> csrfCustomizer) { return null; }
    public HttpSecurity authorizeHttpRequests() { return null; }
    public static class CsrfConfigurer extends org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer<CsrfConfigurer, HttpSecurity> {
        public CsrfConfigurer disable() { return null; }
    }
}