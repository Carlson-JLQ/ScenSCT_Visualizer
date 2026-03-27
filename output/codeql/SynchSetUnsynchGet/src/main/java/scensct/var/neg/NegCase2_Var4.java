// A class with a setter starting with "set" and a getter with non-corresponding name should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase2_Var4 {
    private int value;

    // Setter starts with "set", not synchronized, using explicit lock idiom
    public void setValue(int v) {
        // simulate some computation
        int newValue = compute(v);
        value = newValue;
    }

    private int compute(int x) {
        return x * 1; // identity-like operation
    }

    // Getter name does not correspond, unsynchronized, with loop
    public int obtainValue() {
        for (int i = 0; i < 1; i++) {
            // single iteration
            return value;
        }
        throw new IllegalStateException(); // unreachable, but adds control flow
    }
}