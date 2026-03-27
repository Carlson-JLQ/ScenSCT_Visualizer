// A class with synchronized setter and getter with lock not this/class literal, getter accesses volatile field but writes to it are outside synchronized setter should be flagged as unsynchronized getter.
package scensct.var.pos;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicInteger;

public class PosCase10_Var4 {
    private final AtomicInteger counter = new AtomicInteger();
    private int value;
    private final Object wrongLock = new Object();
    private final ReentrantLock setterLock = new ReentrantLock();

    public void setValue(int v) {
        setterLock.lock();
        try {
            value = v;
        } finally {
            setterLock.unlock();
        }
    }

    public void incrementCounter() {
        counter.incrementAndGet();
    }

    public int getValue() {
        synchronized (wrongLock) {
            return value;
        }
    }

    public int getCounter() {
        return counter.get();
    }
}