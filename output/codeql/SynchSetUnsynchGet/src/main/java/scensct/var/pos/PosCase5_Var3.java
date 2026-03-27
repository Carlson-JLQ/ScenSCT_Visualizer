// A class with synchronized setter and unsynchronized getter, getter accesses volatile field but writes to it are outside synchronized setter should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase5_Var3 {
    private volatile int counter;
    private int value;

    public synchronized void setValue(int v) {
        writeValue(v); // Extract write to helper
    }

    private void writeValue(int v) { // Helper method
        value = v;
    }

    public void incrementCounter() {
        synchronized (this) { // Add redundant synchronized block (not on setter)
            counter++;
        }
    }

    public int getValue() { // [REPORTED LINE]
        return readValue(); // Extract read to helper
    }

    private int readValue() { // Helper method
        return value;
    }

    public int getCounter() {
        return counter;
    }
}