// A class with synchronized setter and unsynchronized getter, getter accesses volatile field but no write to it exists should be flagged as unsynchronized getter.
package scensct.var.pos;

import java.util.concurrent.locks.ReentrantLock;

public class PosCase4_Var4 {
    private volatile int status;
    private int value;
    private final ReentrantLock lock = new ReentrantLock();

    // Setter using ReentrantLock instead of synchronized method
    public void setValue(int v) {
        lock.lock();
        try {
            value = v; // No volatile write
        } finally {
            lock.unlock();
        }
    }

    // Unsynchronized getter (no lock) - should be reported
    public int getValue() {
        return value;
    }

    // Volatile field getter with multiple reads (still no write)
    public int getStatus() {
        int s1 = status;
        int s2 = status; // Second read, no effect on rule
        return s1;
    }
}