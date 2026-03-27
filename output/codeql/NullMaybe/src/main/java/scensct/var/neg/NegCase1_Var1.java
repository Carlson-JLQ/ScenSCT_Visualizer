// Variable dereferenced with provably non-null value should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - using String.valueOf with a non-null argument
        String s = String.valueOf("non-null literal");
        System.out.println(s.length());
    }
}