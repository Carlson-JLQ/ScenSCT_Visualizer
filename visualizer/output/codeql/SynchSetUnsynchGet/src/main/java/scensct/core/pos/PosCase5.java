// A class with synchronized setter and unsynchronized getter, getter accesses volatile field but writes to it are outside synchronized setter should be flagged as unsynchronized getter.
package scensct.core.pos;

public class PosCase5 {
    private volatile int counter; // Volatile field accessed by getter
    private int value;

    public synchronized void setValue(int v) {
        value = v; // Does not write to volatile field
    }

    public void incrementCounter() { // Writes to volatile field, but not in synchronized setter
        counter++;
    }

    public int getValue() { // Unsynchronized getter // [REPORTED LINE]
        return value; // Accesses non-volatile field
    }

    public int getCounter() { // Accesses volatile field
        return counter;
    }
}