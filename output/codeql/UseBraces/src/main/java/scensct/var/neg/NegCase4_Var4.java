// Non-block body where successor is not immediate after final ancestor should not be flagged.
package scensct.var.neg;

public class NegCase4_Var4 {
    public static void main(String[] args) {
        int val = 1;
        // Extract condition to a local variable
        boolean positive = val > 0;
        if (positive)
            System.out.println("Positive");
        // Separate with a labeled statement
        separator:
        System.out.println("After if");
    }
}