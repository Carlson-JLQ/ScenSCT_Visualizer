package org.springframework.security.config.annotation.web.builders;

public class HttpSecurity {
    public org.springframework.security.config.annotation.web.builders.HttpSecurity.ExpressionInterceptUrlRegistry authorizeRequests() { return new ExpressionInterceptUrlRegistry(); }
    public org.springframework.security.config.annotation.web.builders.HttpSecurity.CsrfConfigurer csrf() { return new CsrfConfigurer(); }
    public org.springframework.security.config.annotation.web.builders.HttpSecurity.AuthorizationManagerRequestMatcherRegistry authorize() { return new AuthorizationManagerRequestMatcherRegistry(); }
    public org.springframework.security.config.annotation.web.builders.HttpSecurity.AuthorizationManagerRequestMatcherRegistry authorize(java.util.function.Consumer<org.springframework.security.config.annotation.web.builders.HttpSecurity.AuthorizationManagerRequestMatcherRegistry> consumer) { consumer.accept(new AuthorizationManagerRequestMatcherRegistry()); return null; }
    public org.springframework.security.config.annotation.web.builders.HttpSecurity.RequestMatcherConfigurer requestMatchers() { return new RequestMatcherConfigurer(); }
    public org.springframework.security.config.annotation.web.builders.HttpSecurity.RequestMatcherConfigurer requestMatchers(String... patterns) { return new RequestMatcherConfigurer(); }
    public org.springframework.security.config.annotation.web.builders.HttpSecurity.AuthorizationManagerRequestMatcherRegistry authorizeHttpRequests() { return new AuthorizationManagerRequestMatcherRegistry(); }
    public org.springframework.security.config.annotation.web.builders.HttpSecurity.AuthorizationManagerRequestMatcherRegistry authorizeHttpRequests(java.util.function.Consumer<org.springframework.security.config.annotation.web.builders.HttpSecurity.AuthorizationManagerRequestMatcherRegistry> consumer) { consumer.accept(new AuthorizationManagerRequestMatcherRegistry()); return null; }

    public static class ExpressionInterceptUrlRegistry {
        public org.springframework.security.config.annotation.web.builders.HttpSecurity.ExpressionInterceptUrlRegistry antMatchers(String... patterns) { return this; }
        public org.springframework.security.config.annotation.web.builders.HttpSecurity.ExpressionInterceptUrlRegistry anyRequest() { return this; }
        public org.springframework.security.config.annotation.web.builders.HttpSecurity.ExpressionInterceptUrlRegistry authenticated() { return this; }
        public org.springframework.security.config.annotation.web.builders.HttpSecurity.ExpressionInterceptUrlRegistry permitAll() { return this; }
        public org.springframework.security.config.annotation.web.builders.HttpSecurity.ExpressionInterceptUrlRegistry hasRole(String role) { return this; }
    }

    public class CsrfConfigurer {
        public HttpSecurity disable() { return HttpSecurity.this; }
        public HttpSecurity permitAll() { return HttpSecurity.this; }
    }

    public static class AuthorizationManagerRequestMatcherRegistry {
        public org.springframework.security.config.annotation.web.builders.HttpSecurity.AuthorizationManagerRequestMatcherRegistry requestMatchers(String... patterns) { return this; }
        public org.springframework.security.config.annotation.web.builders.HttpSecurity.AuthorizationManagerRequestMatcherRegistry anyRequest() { return this; }
        public org.springframework.security.config.annotation.web.builders.HttpSecurity.AuthorizationManagerRequestMatcherRegistry permitAll() { return this; }
    }

    public static class RequestMatcherConfigurer {
        public org.springframework.security.config.annotation.web.builders.HttpSecurity.AuthorizationManagerRequestMatcherRegistry authorize() { return new AuthorizationManagerRequestMatcherRegistry(); }
        public org.springframework.security.config.annotation.web.builders.HttpSecurity.AuthorizationManagerRequestMatcherRegistry authorize(java.util.function.Consumer<org.springframework.security.config.annotation.web.builders.HttpSecurity.AuthorizationManagerRequestMatcherRegistry> consumer) { consumer.accept(new AuthorizationManagerRequestMatcherRegistry()); return null; }
        public org.springframework.security.config.annotation.web.builders.HttpSecurity.RequestMatcherConfigurer requestMatchers(String... patterns) { return this; }
    }
}