// Call indexOf on a Vector<Character> with a first argument of type Long should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Vector;

public class PosCase4_Var2 {
    public static void main(String[] args) {
        Vector<Character> v = new Vector<>();
        if (args.length == 0) {
            v.indexOf(100L); // [REPORTED LINE]
        } else {
            // unreachable branch, but preserves scenario
            System.out.println("test");
        }
    }
}