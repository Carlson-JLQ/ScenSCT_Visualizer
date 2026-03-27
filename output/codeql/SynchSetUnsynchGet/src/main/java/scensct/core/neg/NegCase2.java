// A class with a setter starting with "set" and a getter with non-corresponding name should not be flagged as unsynchronized getter with synchronized setter.
package scensct.core.neg;

public class NegCase2 {
    private int value;

    // Setter starts with "set"
    public void setValue(int v) {
        value = v;
    }

    // Getter name does not correspond by replacing "set" with "get"
    public int obtainValue() {
        return value;
    }
}