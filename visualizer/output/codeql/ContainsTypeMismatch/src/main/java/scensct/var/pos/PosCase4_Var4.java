// Call indexOf on a Vector<Character> with a first argument of type Long should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Vector;

public class PosCase4_Var4 {
    public static void main(String[] args) {
        Vector<Character> vec = new Vector<>();
        long primitive = 100L;
        // Autoboxing to Long
        vec.indexOf(primitive); // [REPORTED LINE]
    }
}