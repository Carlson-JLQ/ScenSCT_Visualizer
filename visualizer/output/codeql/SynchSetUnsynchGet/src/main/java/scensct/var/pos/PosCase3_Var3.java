// A class with synchronized setter and getter with incorrect lock object, volatile field exists but getter accesses non-volatile field should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase3_Var3 {
    private int value;
    private volatile int flag;
    private final Object wrongLock = new Object();

    public synchronized void setValue(int v) {
        value = v;
    }

    private Object getLock() { // Helper method returning wrong lock
        return wrongLock;
    }

    public int getValue() { // [REPORTED LINE]
        synchronized (getLock()) { // Lock via method call
            return value;
        }
    }
}