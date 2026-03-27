// A do loop with literal true condition containing a continue should not be flagged as having a continue in a do loop with always false condition.
package scensct.var.neg;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        // Variant 3: Wrap the loop in a try-catch-finally, condition via final variable
        final boolean cond = true;
        try {
            do {
                System.out.println("Loop body");
                continue;
            } while (cond);
        } catch (Exception e) {
            // Never reached
        }
    }
}