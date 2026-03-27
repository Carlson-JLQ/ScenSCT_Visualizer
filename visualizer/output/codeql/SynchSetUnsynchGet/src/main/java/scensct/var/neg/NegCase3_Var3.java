// A class with correctly named getter/setter pair where setter is not synchronized should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase3_Var3 {
    private int value;

    // Delegate assignment to a private helper method (unsynchronized)
    public void setValue(int v) {
        assignValue(v);
    }

    private void assignValue(int v) {
        value = v;
    }

    // Getter delegates to a private helper (unsynchronized)
    public int getValue() {
        return retrieveValue();
    }

    private int retrieveValue() {
        return value;
    }
}