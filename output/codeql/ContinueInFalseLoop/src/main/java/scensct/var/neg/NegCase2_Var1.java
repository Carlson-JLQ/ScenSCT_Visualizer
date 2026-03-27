// A do loop with literal true condition containing a continue should not be flagged as having a continue in a do loop with always false condition.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Variant 1: Use Boolean.TRUE as condition, and add a dummy if around continue
        boolean flag = Boolean.TRUE;
        do {
            System.out.println("Loop body");
            if (flag) {
                continue;
            }
        } while (flag);
    }
}