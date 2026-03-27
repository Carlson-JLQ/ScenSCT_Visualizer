package org.apache.commons.jexl3;

public class JexlEngineBuilder {
    public JexlEngineBuilder sandbox(Object sandbox) {
        return this;
    }
    public JexlEngine create() {
        return new JexlEngine();
    }
}