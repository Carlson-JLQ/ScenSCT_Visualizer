// A do loop with literal false condition containing a continue labeled to target an outer loop should not be flagged as having a continue in that do loop.
package scensct.var.neg;

public class NegCase3_Var2 {
    public static void main(String[] args) {
        int i = 0;
        outer:
        while (i < 2) {
            i++;
            boolean flag = false;
            do {
                String msg = "Inner do loop";
                System.out.println(msg);
                if (true) {
                    continue outer;
                }
            } while (flag);
        }
    }
}