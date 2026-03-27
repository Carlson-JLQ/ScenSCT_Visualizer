// Non-block body with successor on same column/line and indentation not increased should not be flagged.
package scensct.var.neg;

public class NegCase5_Var5 {
    // Variant 5: Control-flow with try-finally around non-core, body column unchanged
    public static void main(String[] args) {
        int count = 2;
        try {
            // try block does not affect column of loop body
            while (count > 0)
                count--; // body same column
        } finally {
            // finally block after loop, but successor is outside
        }
        System.out.println("Done"); // successor same column
    }
}