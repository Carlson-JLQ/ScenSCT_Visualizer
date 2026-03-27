// A class with synchronized setter and getter with lock not this/class literal, no volatile fields should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase7_Var1 {
    private int value;
    private final Object lockObj = new Object();

    public synchronized void setValue(int v) {
        value = v;
    }

    public int getValue() { // [REPORTED LINE]
        Object lock = lockObj;
        synchronized (lock) {
            return value;
        }
    }
}