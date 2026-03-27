// A class with a method pair where the setter does not start with "set" should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase1_Var4 {
    private int value;

    // Delegate assignment through a private helper method
    public void assignValue(int v) {
        internalAssign(v);
    }

    private void internalAssign(int v) {
        value = v;
    }

    // Getter that calls a private helper
    public int retrieveValue() {
        return internalRetrieve();
    }

    private int internalRetrieve() {
        return value;
    }
}