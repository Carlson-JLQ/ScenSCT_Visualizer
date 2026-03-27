// A do loop with a literal false condition contains a continue statement targeting that same loop should be flagged as a positive case.
package scensct.var.pos;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        do {
            if (true) {
                // continue inside do with false condition
                continue; // [REPORTED LINE]
            }
        } while (false);
    }
}