// A class with a method pair where the setter does not start with "set" should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase1_Var3 {
    private int value;

    // Wrapped assignment in a try-catch block (no exception thrown)
    public void assignValue(int v) {
        try {
            value = v;
        } catch (Exception e) {
            // Never happens
        }
    }

    // Getter with conditional that always returns the field
    public int retrieveValue() {
        if (value >= Integer.MIN_VALUE) {
            return value;
        }
        return -1; // unreachable
    }
}