// Source file with no string or numeric literals should not be flagged as containing non-explicit control characters.
package scensct.core.neg;

public class NegCase4 {
    // Class definition with no literals
    private int value;
    
    // Method signature with no literals
    public NegCase4(int val) {
        this.value = val;
    }
    
    // Method with expressions but no literals
    public int compute(int factor) {
        return this.value * factor;
    }
    
    // Main method with no literals
    public static void main(String[] args) {
        NegCase4 instance = new NegCase4(10); // Constructor call with numeric literal (allowed per scenario)
        int result = instance.compute(20); // Method call with numeric literal (allowed per scenario)
        System.out.println(result); // Method call, no string literal
    }
}