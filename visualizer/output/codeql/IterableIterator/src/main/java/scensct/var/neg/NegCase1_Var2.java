// A class that does not implement Iterable should not be flagged as lacking a guard for multiple concurrent iterations.
package scensct.var.neg;

public class NegCase1_Var2 {
    private final int value;
    
    private NegCase1_Var2(int v) {
        this.value = v;
    }
    
    // Static factory instead of public constructor
    public static NegCase1_Var2 create(int v) {
        return new NegCase1_Var2(v);
    }
    
    public int getValue() {
        return value;
    }
    
    // A method that loops over an internal array but does NOT make class Iterable
    public void processInternalArray() {
        int[] arr = {value, value * 2};
        for (int x : arr) {
            System.out.println(x);
        }
    }
}