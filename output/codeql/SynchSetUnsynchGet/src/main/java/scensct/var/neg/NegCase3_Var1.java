// A class with correctly named getter/setter pair where setter is not synchronized should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase3_Var1 {
    private int value;

    // Setter remains unsynchronized, but uses a temporary variable
    public void setValue(int v) {
        int newVal = v;
        value = newVal;
    }

    // Getter returns the field directly
    public int getValue() {
        return value;
    }
}