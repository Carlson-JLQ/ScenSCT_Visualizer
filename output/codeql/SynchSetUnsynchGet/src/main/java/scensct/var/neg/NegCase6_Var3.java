// A class with correctly named getter/setter pair accessing a volatile field should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase6_Var3 {
    private volatile int value;

    // extracted assignment logic, still synchronized
    public synchronized void setValue(int v) {
        assign(v);
    }

    private void assign(int v) {
        value = v;
    }

    // unsynchronized getter
    public int getValue() { // [REPORTED LINE]
        return value;
    }
}