// A class with correctly named getter/setter pair where setter is synchronized and getter uses synchronized block should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase4_Var3 {
    private int value;

    // Synchronized setter
    public synchronized void setValue(int v) {
        value = v;
    }

    // Getter delegates to a private synchronized-helper method
    public int getValue() { // [REPORTED LINE]
        return readValue();
    }

    private synchronized int readValue() {
        return value;
    }
}