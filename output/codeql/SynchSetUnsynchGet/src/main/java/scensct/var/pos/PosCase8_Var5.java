// A class with synchronized setter and getter with lock not this/class literal, volatile field exists but getter accesses non-volatile field should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase8_Var5 {
    private int value;
    private volatile int flag;
    private final Object wrongLock = new Object();

    public synchronized void setValue(int v) {
        value = v;
    }

    private Object getLock() {
        return wrongLock;
    }

    public int getValue() { // [REPORTED LINE]
        synchronized (getLock()) { // lock not 'this'
            return value;
        }
    }
}