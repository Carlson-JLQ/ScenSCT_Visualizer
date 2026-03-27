// A do loop with literal false condition containing a continue labeled to target an outer loop should not be flagged as having a continue in that do loop.
package scensct.var.neg;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        int count = 0;
        outerLoop:
        for (; count < 2; count++) {
            do {
                System.out.println("Inside do-while with false condition");
                continue outerLoop;
            } while (false);
        }
    }
}