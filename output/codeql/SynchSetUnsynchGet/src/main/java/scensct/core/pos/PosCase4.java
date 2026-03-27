// A class with synchronized setter and unsynchronized getter, getter accesses volatile field but no write to it exists should be flagged as unsynchronized getter.
package scensct.core.pos;

public class PosCase4 {
    private volatile int status; // Volatile field accessed by getter
    private int value;

    public synchronized void setValue(int v) {
        value = v; // Does not write to volatile field
    }

    public int getValue() { // Unsynchronized getter // [REPORTED LINE]
        return value; // Accesses non-volatile field
    }

    public int getStatus() { // Accesses volatile field but no write exists
        return status;
    }
}