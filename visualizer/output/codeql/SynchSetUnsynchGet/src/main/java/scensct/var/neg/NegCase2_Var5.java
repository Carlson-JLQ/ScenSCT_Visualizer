// A class with a setter starting with "set" and a getter with non-corresponding name should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase2_Var5 {
    private int value;

    // Setter starts with "set", synchronized, with try-catch
    public synchronized void setValue(int v) {
        try {
            value = v;
        } catch (Exception e) {
            // ignore
        }
    }

    // Getter with non-corresponding name, unsynchronized, using ternary
    public int obtainValue() {
        return (value != Integer.MAX_VALUE) ? value : 0;
    }
}