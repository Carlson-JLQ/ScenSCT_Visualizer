// A class with synchronized setter and getter with lock not this/class literal, getter accesses volatile field but writes to it are outside synchronized setter should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase10_Var5 {
    private volatile int counter;
    private int value;
    private final Object wrongLock = new Object();

    public synchronized void setValue(int v) {
        if (v < 0) {
            value = 0;
        } else {
            value = v;
        }
    }

    public void incrementCounter() {
        counter += 1;
    }

    public int getValue() { // [REPORTED LINE]
        synchronized (wrongLock) {
            if (value > 1000) {
                return value;
            }
            return value;
        }
    }

    public int getCounter() {
        return counter;
    }
}