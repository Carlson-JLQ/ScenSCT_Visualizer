// Non-block body where successor is not immediate after final ancestor should not be flagged.
package scensct.var.neg;

public class NegCase4_Var2 {
    public static void main(String[] args) {
        int val = 1;
        if (val > 0)
            System.out.println("Positive"); // inline comment after body
        // blank line

        System.out.println("After if");
    }
}