// A @ThreadSafe class has a non-volatile, non-thread-safe field accessed with inconsistent monitor objects should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.locks.ReentrantLock;

@ThreadSafe
public class PosCase4_Var5 {
    private int count; // [REPORTED LINE]
    private final ReentrantLock rlock = new ReentrantLock(); // different lock type
    private final Object lock = new Object();

    static {
        // dummy static block
    }

    public synchronized void increment() {
        count++;
    }

    public void decrement() {
        rlock.lock();
        try {
            count--;
        } finally {
            rlock.unlock();
        }
    }
}