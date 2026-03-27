// Double-checked locking where side-effects in synchronized block are only println calls should not be flagged as a race condition.
package scensct.var.neg;

import java.util.concurrent.atomic.AtomicReference;

public class NegCase4_Var4 {
    private AtomicReference<Object> ref = new AtomicReference<>();

    public Object getField() {
        Object val = ref.get();
        if (val == null) {
            synchronized (this) {
                val = ref.get();
                if (val == null) {
                    val = new Object();
                    System.out.println("Atomic ref initialized");
                    int dummy = 3;
                    ref.set(val);
                }
            }
        }
        return val;
    }
}