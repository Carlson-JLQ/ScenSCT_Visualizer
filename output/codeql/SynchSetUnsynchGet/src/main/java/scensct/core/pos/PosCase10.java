// A class with synchronized setter and getter with lock not this/class literal, getter accesses volatile field but writes to it are outside synchronized setter should be flagged as unsynchronized getter.
package scensct.core.pos;

public class PosCase10 {
    private volatile int counter;
    private int value;
    private final Object wrongLock = new Object();

    public synchronized void setValue(int v) {
        value = v; // Does not write to volatile field
    }

    public void incrementCounter() { // Writes to volatile field, but not in synchronized setter
        counter++;
    }

    public int getValue() { // [REPORTED LINE]
        synchronized (wrongLock) { // Lock not 'this'
            return value; // Accesses non-volatile field
        }
    }

    public int getCounter() { // Accesses volatile field
        return counter;
    }
}