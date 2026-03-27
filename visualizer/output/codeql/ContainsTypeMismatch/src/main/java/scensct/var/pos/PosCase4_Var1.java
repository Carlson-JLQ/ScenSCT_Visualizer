// Call indexOf on a Vector<Character> with a first argument of type Long should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Vector;

public class PosCase4_Var1 {
    public static void main(String[] args) {
        Vector<Character> charVec = new Vector<Character>();
        Long target = Long.valueOf(100L);
        charVec.indexOf(target); // [REPORTED LINE]
    }
}