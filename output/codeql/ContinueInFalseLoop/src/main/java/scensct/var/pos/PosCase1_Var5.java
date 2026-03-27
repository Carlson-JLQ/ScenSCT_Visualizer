// A do loop with a literal false condition contains a continue statement targeting that same loop should be flagged as a positive case.
package scensct.var.pos;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        boolean flag = Boolean.FALSE;
        do {
            // continue inside do with false condition
            continue;
        } while (flag);
    }
}