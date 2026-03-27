// A class with synchronized setter and getter with lock not this/class literal, getter accesses volatile field but writes to it are outside synchronized setter should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase10_Var2 {
    private volatile int counter;
    private int value;
    private final Object customLock = new Object();

    public synchronized void setValue(int v) {
        value = v;
    }

    public void incrementCounter() {
        counter++;
    }

    public int getValue() { // [REPORTED LINE]
        synchronized (customLock) {
            int result = value;
            return result;
        }
    }

    public int getCounter() {
        return counter;
    }
}