// A method with null check on f not being the outer if condition should not be flagged as double-checked locking.
package scensct.var.neg;

import java.util.Optional;

public class NegCase5_Var5 {
    private Object f; // non-volatile field

    public void method() {
        // Use Optional to indirectly test null, but outer if checks Optional state
        Optional<Object> opt = Optional.ofNullable(f);
        if (opt.isEmpty()) {
            synchronized (this) {
                if (f == null) {
                    f = new Object();
                }
            }
        }
    }
}