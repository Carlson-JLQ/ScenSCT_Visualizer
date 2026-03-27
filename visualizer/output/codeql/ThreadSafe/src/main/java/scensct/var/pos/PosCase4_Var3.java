// A @ThreadSafe class has a non-volatile, non-thread-safe field accessed with inconsistent monitor objects should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase4_Var3 {
    private int count; // [REPORTED LINE]
    private final Object lock = new Object();

    public void increment() {
        doIncrement();
    }

    private synchronized void doIncrement() { // synchronized on 'this'
        count++;
    }

    public void decrement() {
        synchronized (lock) {
            count--;
        }
    }
}