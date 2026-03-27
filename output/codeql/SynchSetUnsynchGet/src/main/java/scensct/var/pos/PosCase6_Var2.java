// A class with synchronized setter and getter with incorrect lock object, getter accesses volatile field but writes to it are outside synchronized setter should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase6_Var2 {
    private volatile int counter;
    private int value;
    private final Object wrongLock = new Object();

    public synchronized void setValue(int v) {
        value = v;
    }

    public void incrementCounter() {
        counter++;
    }

    private Object getLock() { // Helper method returning incorrect lock
        return wrongLock;
    }

    public int getValue() { // [REPORTED LINE]
        synchronized (getLock()) { // Lock via method call
            int result = value; // Temporary variable
            return result;
        }
    }

    public int getCounter() {
        return counter;
    }
}