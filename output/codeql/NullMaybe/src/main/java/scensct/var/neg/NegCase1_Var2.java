// Variable dereferenced with provably non-null value should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        // Variant 2: Intra-procedural refactoring - temporary variable and redundant assignment
        String t = "constant";
        String s = t;
        // No change to s's nullness
        System.out.println(s.length());
    }
}