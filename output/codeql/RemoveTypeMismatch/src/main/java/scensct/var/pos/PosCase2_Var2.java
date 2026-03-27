// Call removeElement on a java.util.Vector with an argument of a type that is incompatible with the vector's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.Vector;

public class PosCase2_Var2 {
    public static void main(String[] args) {
        Vector<Double> vec = new Vector<>();
        vec.add(Math.PI);
        if (true) {
            // Wrapped in always-true conditional
            vec.removeElement("incompatible"); // [REPORTED LINE]
        }
    }
}