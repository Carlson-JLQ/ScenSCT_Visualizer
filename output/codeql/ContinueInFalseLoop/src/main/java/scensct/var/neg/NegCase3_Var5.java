// A do loop with literal false condition containing a continue labeled to target an outer loop should not be flagged as having a continue in that do loop.
package scensct.var.neg;

public class NegCase3_Var5 {
    public static void main(String[] args) {
        int iterations = 0;
        outer:
        while (iterations < 2) {
            iterations++;
            // Introduce a temporary variable to obscure the false condition slightly
            final boolean neverTrue = (1 > 2);
            do {
                System.out.println("Do body");
                continue outer;
            } while (neverTrue);
        }
    }
}