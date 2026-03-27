package com.exp;

import java.io.InputStream;

public class ValidatingObjectInputStream {
    public ValidatingObjectInputStream(InputStream in) {}
    public void accept(Class<?> clazz) {}
    public Object readObject() { return null; }
    public void close() {}
}