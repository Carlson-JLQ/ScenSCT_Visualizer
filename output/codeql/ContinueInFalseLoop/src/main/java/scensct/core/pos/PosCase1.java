// A do loop with a literal false condition contains a continue statement targeting that same loop should be flagged as a positive case.
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        do {
            // continue inside do with false condition
            continue; // [REPORTED LINE]
        } while (false);
    }
}