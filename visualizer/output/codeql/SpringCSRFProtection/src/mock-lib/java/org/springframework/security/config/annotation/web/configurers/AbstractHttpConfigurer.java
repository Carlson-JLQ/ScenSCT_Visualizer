package org.springframework.security.config.annotation.web.configurers;

public abstract class AbstractHttpConfigurer<T extends AbstractHttpConfigurer<T, B>, B> {
    public T disable() { return null; }
}