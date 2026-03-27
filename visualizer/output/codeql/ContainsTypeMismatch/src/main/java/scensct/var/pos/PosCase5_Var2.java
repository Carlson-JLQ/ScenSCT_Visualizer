// Call lastIndexOf on a Vector<Byte> with an argument of type Float (first argument) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Vector;

public class PosCase5_Var2 {
    public static void main(String[] args) {
        Vector<Byte> data = createVector();
        invokeLastIndexOf(data, 3.14f);
    }

    private static Vector<Byte> createVector() {
        return new Vector<>();
    }

    private static void invokeLastIndexOf(Vector<Byte> v, float f) {
        // Parameter type float is widened to Float via autoboxing at call site
        v.lastIndexOf(f); // [REPORTED LINE]
    }
}