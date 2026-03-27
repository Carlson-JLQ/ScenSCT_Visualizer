// A class with correctly named getter/setter pair where setter is not synchronized should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase3_Var5 {
    private int value;

    // Setter wrapped in a try-finally (no synchronization)
    public void setValue(int v) {
        try {
            value = v;
        } finally {
            // nothing
        }
    }

    // Getter wrapped in try-catch for no exception
    public int getValue() {
        try {
            return value;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}