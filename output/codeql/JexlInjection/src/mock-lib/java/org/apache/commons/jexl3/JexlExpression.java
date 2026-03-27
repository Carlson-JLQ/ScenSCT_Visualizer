package org.apache.commons.jexl3;

public interface JexlExpression {
    Object evaluate(JexlContext context);
}