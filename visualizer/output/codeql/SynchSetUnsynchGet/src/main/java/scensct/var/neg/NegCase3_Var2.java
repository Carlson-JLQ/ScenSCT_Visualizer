// A class with correctly named getter/setter pair where setter is not synchronized should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase3_Var2 {
    private int value;

    // Setter with a trivial guard (always true) – still unsynchronized
    public void setValue(int v) {
        if (true) {
            value = v;
        }
    }

    // Getter with an explicit local variable
    public int getValue() {
        int result = value;
        return result;
    }
}