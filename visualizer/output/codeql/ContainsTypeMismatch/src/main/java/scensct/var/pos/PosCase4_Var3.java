// Call indexOf on a Vector<Character> with a first argument of type Long should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Vector;

public class PosCase4_Var3 {
    private static void checkIndex(Vector<Character> vec, Long l) {
        vec.indexOf(l); // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        Vector<Character> vec = new Vector<>();
        checkIndex(vec, 100L);
    }
}