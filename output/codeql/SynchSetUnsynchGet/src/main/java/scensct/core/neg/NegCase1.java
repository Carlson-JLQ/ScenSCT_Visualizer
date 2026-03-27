// A class with a method pair where the setter does not start with "set" should not be flagged as unsynchronized getter with synchronized setter.
package scensct.core.neg;

public class NegCase1 {
    private int value;

    // Intended setter but name does not start with "set"
    public void assignValue(int v) {
        value = v;
    }

    // Getter with any name
    public int retrieveValue() {
        return value;
    }
}