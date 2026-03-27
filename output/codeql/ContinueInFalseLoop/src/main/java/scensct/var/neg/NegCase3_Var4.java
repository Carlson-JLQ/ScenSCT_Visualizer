// A do loop with literal false condition containing a continue labeled to target an outer loop should not be flagged as having a continue in that do loop.
package scensct.var.neg;

public class NegCase3_Var4 {
    public static void main(String[] args) {
        runOuterLoop();
    }

    private static void runOuterLoop() {
        int iterations = 0;
        outer:
        while (iterations < 2) {
            iterations++;
            do {
                System.out.println("Inner do loop");
                continue outer;
            } while (false);
        }
    }
}