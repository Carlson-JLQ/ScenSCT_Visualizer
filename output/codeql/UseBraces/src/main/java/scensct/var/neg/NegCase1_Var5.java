// Control structure body is a block statement should not be flagged as misleading indentation.
package scensct.var.neg;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        int x = 5;
        // if with braced body, nested in a trivial try-catch-finally
        try {
            if (x > 0) {
                System.out.println("Positive");
            } else {
                System.out.println("Non-positive");
            }
        } catch (Exception e) {
            // ignore
        } finally {
            // empty
        }
        // for loop with braces, loop variable declared outside
        int i;
        for (i = 0; i < 3; i++) {
            System.out.println(i);
        }
        // while loop with braces, using a labeled break
        outer:
        while (x > 0) {
            x--;
            if (x < 0) break outer;
        }
    }
}