// A class with a method pair where the setter does not start with "set" should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase1_Var1 {
    private int data;

    // Renamed field and method, still not "set" prefix
    public void updateData(int val) {
        this.data = val;
    }

    // Getter renamed, using this for access
    public int fetchData() {
        return this.data;
    }
}