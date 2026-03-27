// A class with synchronized setter and unsynchronized getter, volatile field exists but getter accesses non-volatile field should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase2_Var5 {
    private int value;
    private volatile int flag;

    public synchronized void setValue(int v) {
        synchronized (this) { // nested synchronized block, equivalent
            value = v;
        }
    }

    public int getValue() { // unsynchronized // [REPORTED LINE]
        return value;
    }
}