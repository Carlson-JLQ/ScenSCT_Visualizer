// A do loop with a literal false condition contains a continue statement targeting that same loop should be flagged as a positive case.
package scensct.var.pos;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        outer: do {
            // continue inside do with false condition
            continue outer; // [REPORTED LINE]
        } while (false);
    }
}