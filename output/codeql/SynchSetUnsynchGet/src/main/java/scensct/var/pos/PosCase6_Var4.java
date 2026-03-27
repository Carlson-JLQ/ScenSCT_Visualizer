// A class with synchronized setter and getter with incorrect lock object, getter accesses volatile field but writes to it are outside synchronized setter should be flagged as unsynchronized getter.
package scensct.var.pos;

import java.util.concurrent.locks.ReentrantLock;

public class PosCase6_Var4 {
    private volatile int counter;
    private int value;
    private final ReentrantLock wrongLock = new ReentrantLock(); // Different lock type

    public synchronized void setValue(int v) {
        value = v;
    }

    public void incrementCounter() {
        counter++;
    }

    public int getValue() { // [REPORTED LINE]
        wrongLock.lock(); // Manual lock, still incorrect
        try {
            return value;
        } finally {
            wrongLock.unlock();
        }
    }

    public int getCounter() {
        return counter;
    }
}