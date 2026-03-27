package org.springframework.expression;

public interface Expression {
    Object getValue();
    Object getValue(Object context);
}