// Variable dereferenced with provably non-null value should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase1_Var4 {
    // Variant 4: Idiomatic variation - using a final static field (constant)
    private static final String CONST = "fixed";
    
    public static void main(String[] args) {
        String s = CONST;
        System.out.println(s.length());
    }
}