// A class with a method pair where the setter does not start with "set" should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase1_Var5 {
    private int value;

    // Setter-like method with a different modifier order
    final public void assignValue(int v) {
        value = v;
    }

    // Getter made final as well, but still unsynchronized
    final public int retrieveValue() {
        return value;
    }
}