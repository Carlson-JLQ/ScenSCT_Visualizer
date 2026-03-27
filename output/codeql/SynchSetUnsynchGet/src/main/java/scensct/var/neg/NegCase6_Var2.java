// A class with correctly named getter/setter pair accessing a volatile field should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase6_Var2 {
    private volatile int value;

    // setter with trivial control flow
    public synchronized void setValue(int v) {
        if (v >= Integer.MIN_VALUE) {
            value = v;
        } else {
            value = 0;
        }
    }

    // getter with a redundant local variable
    public int getValue() { // [REPORTED LINE]
        int result = value;
        return result;
    }
}