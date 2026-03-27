package org.apache.commons.jexl3;

public class JexlBuilder {
    public JexlBuilder sandbox(Object o) {
        return this;
    }
    public JexlEngine create() {
        return new JexlEngine();
    }
}