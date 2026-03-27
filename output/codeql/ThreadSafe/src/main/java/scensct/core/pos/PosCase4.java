// A @ThreadSafe class has a non-volatile, non-thread-safe field accessed with inconsistent monitor objects should be flagged as improperly synchronized.
package scensct.core.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase4 {
    private int count; // Non-volatile, non-thread-safe field // [REPORTED LINE]
    private final Object lock = new Object();

    public synchronized void increment() {
        count++; // Synchronized on 'this'
    }

    public void decrement() {
        synchronized (lock) {
            count--; // Synchronized on different monitor 'lock'
        }
    }
}