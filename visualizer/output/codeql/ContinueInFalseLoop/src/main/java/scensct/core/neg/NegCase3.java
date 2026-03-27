// A do loop with literal false condition containing a continue labeled to target an outer loop should not be flagged as having a continue in that do loop.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        int iterations = 0;
        outer: // Label for outer loop
        while (iterations < 2) {
            iterations++;
            do {
                System.out.println("Inner do loop");
                continue outer; // Labeled continue targets outer loop, not this do loop
            } while (false); // Condition is literal false, but continue does not apply here
        }
    }
}