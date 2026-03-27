// A class that does not implement Iterable should not be flagged as lacking a guard for multiple concurrent iterations.
package scensct.var.neg;

public class NegCase1_Var3 {
    private final int value;
    
    public NegCase1_Var3(int v) {
        value = v;
    }
    
    public int getValue() {
        return value;
    }
    
    // Delegate display to another class
    public void display() {
        new DisplayHelper().show(value);
    }
    
    // Inner helper class – still no Iterable implementation
    private static class DisplayHelper {
        void show(int val) {
            System.out.println("Value is " + val);
        }
    }
}