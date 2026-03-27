// A class with synchronized setter and getter with lock not this/class literal, volatile field exists but getter accesses non-volatile field should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase8_Var1 {
    private int value;
    private volatile int flag;
    private final Object wrongLock = new Object();

    public synchronized void setValue(int v) {
        value = v;
    }

    public int getValue() { // [REPORTED LINE]
        final Object lock = wrongLock; // alias
        synchronized (lock) {
            int result = value; // read into local
            return result;
        }
    }
}