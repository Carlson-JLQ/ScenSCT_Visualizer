// A class with synchronized setter and getter with incorrect lock object, volatile field exists but getter accesses non-volatile field should be flagged as unsynchronized getter.
package scensct.var.pos;

import java.util.concurrent.locks.ReentrantLock;

public class PosCase3_Var5 {
    private int value;
    private volatile int flag;
    private final Object wrongLock = new Object();
    private final ReentrantLock setterLock = new ReentrantLock(); // Different lock type for setter

    public void setValue(int v) {
        setterLock.lock(); // Using ReentrantLock instead of synchronized
        try {
            value = v;
        } finally {
            setterLock.unlock();
        }
    }

    public int getValue() { // [REPORTED LINE]
        synchronized (wrongLock) { // Still wrong lock object
            return value;
        }
    }
}