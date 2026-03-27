// A @ThreadSafe class has a non-volatile, non-thread-safe field accessed with inconsistent monitor objects should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase4_Var4 {
    private int count; // [REPORTED LINE]
    private final Object lock = new Object();

    public void increment() {
        synchronized (this) { // explicit block instead of synchronized method
            count++;
        }
    }

    public void decrement() {
        Object guard = lock; // alias
        synchronized (guard) {
            count--;
        }
    }
}