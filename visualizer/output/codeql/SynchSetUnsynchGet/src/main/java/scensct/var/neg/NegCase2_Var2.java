// A class with a setter starting with "set" and a getter with non-corresponding name should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase2_Var2 {
    private int value;

    // Setter starts with "set", not synchronized
    public void setValue(int val) {
        // trivial control flow
        if (val >= Integer.MIN_VALUE) {
            value = val;
        } else {
            value = 0;
        }
    }

    // Getter name does not correspond, unsynchronized, with try-finally
    public int obtainValue() {
        try {
            return value;
        } finally {
            // no-op, just to add complexity
            System.gc();
        }
    }
}