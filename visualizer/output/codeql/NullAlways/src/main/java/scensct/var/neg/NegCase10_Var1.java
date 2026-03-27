// Non-dereference access of a non-field variable should not be flagged as always null.
package scensct.var.neg;

public class NegCase10_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring with explicit null assignment and renamed variables
        Object obj = null;
        Object copy = obj; // assignment, not dereference
        boolean nullCheck = (obj == null); // comparison, not dereference
    }
}