// Call removeElement on a java.util.Vector with an argument of a type that is incompatible with the vector's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.Vector;

public class PosCase2_Var3 {
    private static void removeStringFromDoubleVector() {
        Vector<Double> v = new Vector<>();
        v.add(3.14);
        // Call moved to static helper
        v.removeElement("incompatible"); // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        removeStringFromDoubleVector();
    }
}