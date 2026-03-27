// Non-block body where successor is not immediate after final ancestor should not be flagged.
package scensct.var.neg;

public class NegCase4_Var1 {
    public static void main(String[] args) {
        int value = 1;
        // if with single statement body
        if (value > 0)
            System.out.println("Positive");
        // A comment line separates the if from the next statement
        // This maintains non-immediacy
        System.out.println("After if");
    }
}