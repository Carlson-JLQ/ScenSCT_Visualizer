// A class with correctly named getter/setter pair where setter is not synchronized should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase3_Var4 {
    private int value;

    // Setter uses a loop that runs once – still unsynchronized
    public void setValue(int v) {
        for (int i = 0; i < 1; i++) {
            value = v;
        }
    }

    // Getter uses a ternary operator trivially
    public int getValue() {
        return value != Integer.MAX_VALUE ? value : value;
    }
}