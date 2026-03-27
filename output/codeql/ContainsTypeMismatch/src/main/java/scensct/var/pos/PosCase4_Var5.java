// Call indexOf on a Vector<Character> with a first argument of type Long should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Vector;

public class PosCase4_Var5 {
    public static void main(String[] args) {
        Vector<Character> vec = new Vector<>();
        for (int i = 0; i < 1; i++) {
            vec.indexOf(100L); // [REPORTED LINE]
            break;
        }
    }
}