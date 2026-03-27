// Double-checked locking with no side-effects besides assignment in synchronized block should not be flagged as a race condition.
package scensct.var.neg;

import java.util.concurrent.atomic.AtomicReference;

public class NegCase2_Var5 {
    private final AtomicReference<Object> ref = new AtomicReference<>();

    public Object getField() {
        Object val = ref.get();
        if (val == null) {
            synchronized (this) {
                val = ref.get();
                if (val == null) {
                    val = new Object();
                    ref.set(val); // atomic set, still no side-effects after assignment
                }
            }
        }
        return ref.get();
    }
}