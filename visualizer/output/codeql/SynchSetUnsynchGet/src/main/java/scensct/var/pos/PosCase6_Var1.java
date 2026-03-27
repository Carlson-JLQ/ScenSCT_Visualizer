// A class with synchronized setter and getter with incorrect lock object, getter accesses volatile field but writes to it are outside synchronized setter should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase6_Var1 {
    private volatile int counter;
    private int data; // Renamed from 'value'
    private final Object mismatchedLock = new Object(); // Renamed from 'wrongLock'

    public synchronized void setValue(int v) {
        this.data = v; // Explicit 'this', field renamed
    }

    public void incrementCounter() {
        counter++; // Unchanged
    }

    public int getValue() { // [REPORTED LINE]
        final Object lock = mismatchedLock; // Alias via local variable
        synchronized (lock) { // Still incorrect lock
            return this.data; // Accesses same non-volatile field
        }
    }

    public int getCounter() {
        return counter;
    }
}