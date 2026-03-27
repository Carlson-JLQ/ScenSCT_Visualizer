// A class that does not implement java.lang.Iterable should not be flagged as non-multiple-iteration iterable.
package scensct.var.neg;

public class NegCase1_Var2 {
    // Changed to a mutable field with a setter, but still no Iterable
    private int value;
    
    public NegCase1_Var2(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int v) {
        this.value = v;
    }
    
    // Added a method returning an array, not an Iterator
    public int[] asArray() {
        return new int[]{value};
    }
}