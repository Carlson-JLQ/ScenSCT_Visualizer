// Synchronized block contains no inner if-statement should not be flagged as a race condition.
package scensct.var.neg;

import java.util.concurrent.atomic.AtomicReference;

public class NegCase10_Var4 {
    private final AtomicReference<Object> fieldRef = new AtomicReference<>();

    public Object getField() {
        Object local = fieldRef.get();
        if (local == null) {
            synchronized (this) {
                local = fieldRef.get();
                if (local == null) {
                    local = new Object();
                    fieldRef.set(local);
                }
            }
        }
        return local;
    }
}