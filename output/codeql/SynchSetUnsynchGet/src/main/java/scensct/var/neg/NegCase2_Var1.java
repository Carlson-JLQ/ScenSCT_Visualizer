// A class with a setter starting with "set" and a getter with non-corresponding name should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase2_Var1 {
    private int data; // renamed field

    // Synchronized setter (starts with "set")
    public synchronized void setValue(int v) {
        this.data = v; // using 'this' and renamed field
    }

    // Getter with non-corresponding name, unsynchronized
    public int obtainValue() {
        return data; // returns the renamed field
    }
}