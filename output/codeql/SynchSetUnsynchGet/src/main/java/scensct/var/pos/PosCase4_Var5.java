// A class with synchronized setter and unsynchronized getter, getter accesses volatile field but no write to it exists should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase4_Var5 {
    private volatile int status;
    private int value;

    // Synchronized setter with loop and temporary
    public synchronized void setValue(int v) {
        int old = value;
        for (int i = 0; i < 1; i++) { // Loop that executes once
            value = v;
        }
        // No volatile write
    }

    // Unsynchronized getter accessing field via this
    public int getValue() { // [REPORTED LINE]
        return this.value; // Explicit this qualifier
    }

    // Volatile getter as a one-liner
    public int getStatus() { return status; }
}