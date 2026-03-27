// Call lastIndexOf on a Vector<Byte> with an argument of type Float (first argument) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Vector;

public class PosCase5_Var3 {
    public static void main(String[] args) {
        Vector<Byte> vec = new Vector<>();
        Number num = 3.14f; // Float assigned to Number
        if (num instanceof Float) {
            // Checker must see the call's argument is still Float
            vec.lastIndexOf((Float) num); // [REPORTED LINE]
        }
    }
}