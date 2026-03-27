// Non-block body where successor is not immediate after final ancestor should not be flagged.
package scensct.var.neg;

public class NegCase4_Var5 {
    public static void main(String[] args) {
        int val = 1;
        // Use try-finally to wrap the successor, but finally does nothing
        if (val > 0)
            System.out.println("Positive");
        try {
            // empty try
        } finally {
            // empty finally
        }
        System.out.println("After if");
    }
}