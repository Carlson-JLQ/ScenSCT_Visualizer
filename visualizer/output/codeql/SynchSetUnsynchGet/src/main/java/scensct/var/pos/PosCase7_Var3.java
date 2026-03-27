// A class with synchronized setter and getter with lock not this/class literal, no volatile fields should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase7_Var3 {
    private int value;
    private final Object customLock = createLock();

    private static Object createLock() {
        return new Object();
    }

    public synchronized void setValue(int v) {
        value = v;
    }

    public int getValue() { // [REPORTED LINE]
        synchronized (customLock) {
            return value;
        }
    }
}