// Call removeElement on a java.util.Vector with an argument of a type that is incompatible with the vector's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.Vector;

public class PosCase2_Var4 {
    public static void main(String[] args) {
        Vector<Double> vec = new Vector<>();
        Double d = 3.14;
        vec.add(d);
        // Incompatible argument is an integer literal (autoboxed to Integer)
        vec.removeElement(42); // [REPORTED LINE]
    }
}