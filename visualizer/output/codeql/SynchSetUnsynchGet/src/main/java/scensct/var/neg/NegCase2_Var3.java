// A class with a setter starting with "set" and a getter with non-corresponding name should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase2_Var3 {
    private int value;

    // Setter starts with "set", synchronized
    public synchronized void setValue(int v) {
        assignValue(v);
    }

    private void assignValue(int v) {
        value = v; // extracted logic
    }

    // Getter with non-corresponding name, unsynchronized
    public int obtainValue() {
        return retrieveValue();
    }

    private int retrieveValue() {
        return value;
    }
}