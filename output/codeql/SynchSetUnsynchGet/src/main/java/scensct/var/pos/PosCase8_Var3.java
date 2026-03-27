// A class with synchronized setter and getter with lock not this/class literal, volatile field exists but getter accesses non-volatile field should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase8_Var3 {
    private int value;
    private volatile int flag;
    private static final class LockHolder {
        static final Object LOCK = new Object();
    }

    public synchronized void setValue(int v) {
        value = v;
    }

    public int getValue() { // [REPORTED LINE]
        synchronized (LockHolder.LOCK) { // still not 'this'
            return this.value;
        }
    }
}