// Call lastIndexOf on a Vector<Byte> with an argument of type Float (first argument) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Vector;

public class PosCase5_Var4 {
    public static void main(String[] args) {
        Vector<Byte> vec = new Vector<>();
        for (int i = 0; i < 1; i++) {
            // Loop doesn't affect reachability
            vec.lastIndexOf(getFloat()); // [REPORTED LINE]
        }
    }

    private static Float getFloat() {
        return 3.14f;
    }
}