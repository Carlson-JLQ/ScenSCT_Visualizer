// A class with synchronized setter and getter with lock not this/class literal, getter accesses volatile field but writes to it are outside synchronized setter should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase10_Var3 {
    private volatile int counter;
    private int value;
    private final Object wrongLock = new Object();

    public synchronized void setValue(int v) {
        value = v;
    }

    public void incrementCounter() {
        counter++;
    }

    private Object getLock() {
        return wrongLock;
    }

    public int getValue() { // [REPORTED LINE]
        synchronized (getLock()) {
            return value;
        }
    }

    public int getCounter() {
        return counter;
    }
}