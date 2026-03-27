// Call lastIndexOf on a Vector<Byte> with an argument of type Float (first argument) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Vector;

public class PosCase5_Var1 {
    public static void main(String[] args) {
        Vector<Byte> bytes = new Vector<Byte>();
        Float searchKey = Float.valueOf(3.14f);
        // Using an intermediate variable of type Float
        bytes.lastIndexOf(searchKey); // [REPORTED LINE]
    }
}