// A class that does not implement java.lang.Iterable should not be flagged as non-multiple-iteration iterable.
package scensct.var.neg;

public class NegCase1_Var1 {
    // Renamed field and added a static factory method
    private final int data;
    
    private NegCase1_Var1(int data) {
        this.data = data;
    }
    
    public static NegCase1_Var1 create(int value) {
        return new NegCase1_Var1(value);
    }
    
    public int getValue() {
        return data;
    }
    
    // Added an unrelated utility method that returns a primitive
    public boolean isPositive() {
        return data > 0;
    }
}