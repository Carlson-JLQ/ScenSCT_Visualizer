// A class with synchronized setter and unsynchronized getter, getter accesses volatile field but writes to it are outside synchronized setter should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase5_Var4 {
    private volatile int counter;
    private int value;

    public synchronized void setValue(int v) {
        try {
            value = v; // Wrap in try-finally
        } finally {
            // Do nothing
        }
    }

    public void incrementCounter() {
        for (int i = 0; i < 1; i++) { // Loop refactoring
            counter++;
        }
    }

    public int getValue() { // [REPORTED LINE]
        if (System.currentTimeMillis() > 0) { // Always true condition
            return value;
        }
        return -1; // Unreachable path
    }

    public int getCounter() {
        return counter;
    }
}