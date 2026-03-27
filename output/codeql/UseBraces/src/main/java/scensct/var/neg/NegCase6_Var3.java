// Non-block body that is a jump/return/throw statement should not be flagged despite misleading indentation.
package scensct.var.neg;

public class NegCase6_Var3 {
    public static void main(String[] args) {
        int value = 5;
        int threshold = 10;
        // Inverted logic
        if (value <= threshold)
            throw new IllegalArgumentException("Too small");
        else
            System.exit(1);
        // Looks like next line belongs to else
    }
}