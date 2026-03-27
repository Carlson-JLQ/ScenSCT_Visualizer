package org.apache.commons.jexl3;

public interface JxltEngine {
    Template createTemplate(String template);
    interface Template {
        Object evaluate(Object context, Object data);
    }
}