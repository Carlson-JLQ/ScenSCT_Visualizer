// A class with a method pair where the setter does not start with "set" should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase1_Var2 {
    private int value;

    // Setter-like method with extra unused parameter (overload simulation)
    public void assignValue(int v, String unused) {
        value = v;
    }

    // Overloaded version that is actually used
    public void assignValue(int v) {
        assignValue(v, null);
    }

    // Getter with explicit temporary variable
    public int retrieveValue() {
        int temp = value;
        return temp;
    }
}