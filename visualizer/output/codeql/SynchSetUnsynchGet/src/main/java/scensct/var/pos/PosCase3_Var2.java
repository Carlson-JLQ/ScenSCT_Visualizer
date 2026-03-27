// A class with synchronized setter and getter with incorrect lock object, volatile field exists but getter accesses non-volatile field should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase3_Var2 {
    private int value;
    private volatile int flag;
    private final Object wrongLock = new Object();

    public void setValue(int v) {
        synchronized (this) { // Explicit synchronized block instead of method modifier
            value = v;
        }
    }

    public int getValue() { // [REPORTED LINE]
        Object lock = wrongLock; // Alias via local variable
        synchronized (lock) {
            int result = value; // Temporary variable
            return result;
        }
    }
}