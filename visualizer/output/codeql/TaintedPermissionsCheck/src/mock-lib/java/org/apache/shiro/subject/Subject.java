package org.apache.shiro.subject;

public interface Subject {
    void checkPermission(String permission);
}