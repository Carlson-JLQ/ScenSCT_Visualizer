package org.springframework.expression.spel.support;

public class SimpleEvaluationContext {
    public static Builder forReadOnlyDataBinding() {
        return new Builder();
    }
    public static class Builder {
        public SimpleEvaluationContext build() {
            return new SimpleEvaluationContext();
        }
    }
}