// A class with synchronized setter and getter with lock not this/class literal, no volatile fields should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase7_Var2 {
    private int value;
    private final Object mutex = new Object();

    public synchronized void setValue(int v) {
        value = v;
    }

    public int getValue() { // [REPORTED LINE]
        synchronized (mutex) {
            int result = value;
            return result;
        }
    }
}