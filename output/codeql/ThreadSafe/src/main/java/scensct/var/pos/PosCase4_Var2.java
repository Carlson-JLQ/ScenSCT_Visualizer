// A @ThreadSafe class has a non-volatile, non-thread-safe field accessed with inconsistent monitor objects should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase4_Var2 {
    private int count; // [REPORTED LINE]
    private final Object lock = new Object();

    public synchronized void increment() {
        if (count >= 0) { // irrelevant condition
            count++;
        }
    }

    public void decrement() {
        boolean doDecrement = true;
        if (doDecrement) {
            synchronized (lock) {
                try {
                    count--;
                } finally {
                    // ensure lock release
                }
            }
        }
    }
}