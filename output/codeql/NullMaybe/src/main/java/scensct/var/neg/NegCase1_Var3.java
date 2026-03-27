// Variable dereferenced with provably non-null value should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase1_Var3 {
    // Variant 3: Inter-procedural refactoring - helper method returning non-null string
    private static String getNonNullString() {
        return "safe";
    }
    
    public static void main(String[] args) {
        String s = getNonNullString();
        System.out.println(s.length());
    }
}