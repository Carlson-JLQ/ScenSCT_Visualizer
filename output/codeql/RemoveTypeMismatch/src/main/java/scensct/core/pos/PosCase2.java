// Call removeElement on a java.util.Vector with an argument of a type that is incompatible with the vector's element type should be flagged as a violation.
package scensct.core.pos;

import java.util.Vector;

public class PosCase2 {
    public static void main(String[] args) {
        Vector<Double> vec = new Vector<>();
        vec.add(3.14);
        // Incompatible argument type String for Vector<Double>.removeElement
        vec.removeElement("incompatible"); // [REPORTED LINE]
    }
}