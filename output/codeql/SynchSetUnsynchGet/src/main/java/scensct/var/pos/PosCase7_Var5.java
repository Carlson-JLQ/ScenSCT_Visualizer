// A class with synchronized setter and getter with lock not this/class literal, no volatile fields should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase7_Var5 {
    private int value;
    private final Object lock = new Object();

    public synchronized void setValue(int v) {
        value = v;
    }

    public int getValue() { // [REPORTED LINE]
        try {
            synchronized (lock) {
                return value;
            }
        } finally {
            // empty finally, just to add control-flow complexity
        }
    }
}