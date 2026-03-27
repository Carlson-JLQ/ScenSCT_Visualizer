// A class with correctly named getter/setter pair accessing a volatile field should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase6_Var5 {
    // volatile field with explicit initializer
    private volatile int value = 0;

    // setter with multiple statements, still synchronized
    public synchronized void setValue(int v) {
        int old = value;
        value = v;
        // dummy use of old to avoid "unused" warning in real code
        if (old == v) {
            // rare case, do nothing
        }
    }

    // unsynchronized getter reading volatile
    public int getValue() {
        return this.value; // qualified with 'this'
    }
}