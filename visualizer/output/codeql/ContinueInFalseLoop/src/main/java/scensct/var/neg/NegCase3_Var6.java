// A do loop with literal false condition containing a continue labeled to target an outer loop should not be flagged as having a continue in that do loop.
package scensct.var.neg;

public class NegCase3_Var6 {
    public static void main(String[] args) {
        int i = 0;
        outer:
        while (i < 2) {
            i++;
            // Add a try-catch block around the do loop, but ensure continue still reaches outer
            try {
                do {
                    System.out.println("Inner");
                    continue outer;
                } while (false);
            } catch (Exception e) {
                // ignore
            }
        }
    }
}