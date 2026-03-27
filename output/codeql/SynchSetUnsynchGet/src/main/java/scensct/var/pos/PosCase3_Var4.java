// A class with synchronized setter and getter with incorrect lock object, volatile field exists but getter accesses non-volatile field should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase3_Var4 {
    private int value;
    private volatile int flag;
    private final Object wrongLock = new Object();

    public synchronized void setValue(int v) {
        value = v;
    }

    public int getValue() { // [REPORTED LINE]
        try {
            synchronized (wrongLock) {
                return value;
            }
        } finally {
            // Empty finally, control-flow obfuscation
        }
    }
}