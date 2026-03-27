// A method with outer if null check on a different field should not be flagged as double-checked locking on field f.
package scensct.var.neg;

import java.util.Objects;

public class NegCase4_Var3 {
    private Object f;
    private Object g;

    public void method() {
        if (Objects.isNull(g)) {
            synchronized (this) {
                try {
                    if (f == null) {
                        f = new Object();
                    }
                } finally {
                    // dummy finally, just to add complexity
                    int x = 1;
                }
            }
        }
    }
}