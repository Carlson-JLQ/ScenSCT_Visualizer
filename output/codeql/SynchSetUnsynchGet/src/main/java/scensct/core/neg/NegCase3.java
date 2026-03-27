// A class with correctly named getter/setter pair where setter is not synchronized should not be flagged as unsynchronized getter with synchronized setter.
package scensct.core.neg;

public class NegCase3 {
    private int value;

    // Correctly named setter but not synchronized
    public void setValue(int v) {
        value = v;
    }

    // Correctly named getter
    public int getValue() {
        return value;
    }
}