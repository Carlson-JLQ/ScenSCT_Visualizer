// A do loop with literal true condition containing a continue should not be flagged as having a continue in a do loop with always false condition.
package scensct.var.neg;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        // Variant 4: Loop with condition (1 < 2) and continue inside a block
        do {
            {
                System.out.println("Loop body");
                continue;
            }
        } while (1 < 2);
    }
}