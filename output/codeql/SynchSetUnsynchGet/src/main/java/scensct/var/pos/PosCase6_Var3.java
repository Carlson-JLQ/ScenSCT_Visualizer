// A class with synchronized setter and getter with incorrect lock object, getter accesses volatile field but writes to it are outside synchronized setter should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase6_Var3 {
    private volatile int counter;
    private int value;
    private final Object wrongLock = new Object();

    public synchronized void setValue(int v) {
        value = v;
    }

    public void incrementCounter() {
        counter++;
    }

    public int getValue() { // [REPORTED LINE]
        // Added trivial control flow that doesn't affect synchronization
        if (System.currentTimeMillis() > 0) {
            synchronized (wrongLock) {
                return value;
            }
        }
        throw new IllegalStateException("Unreachable");
    }

    public int getCounter() {
        return counter;
    }
}