// A method with inner if null check on a different field should not be flagged as double-checked locking on field f.
package scensct.var.neg;

import java.util.Objects;

public class NegCase7_Var2 {
    private Object f;
    private Object g;

    public void method() {
        if (Objects.isNull(f)) {
            Object lock = this;
            synchronized (lock) {
                if (g == null) {
                    f = new Object();
                }
            }
        }
    }
}