// Call removeElement on a java.util.Vector with an argument of a type that is incompatible with the vector's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.Vector;

public class PosCase2_Var5 {
    public static void main(String[] args) {
        Vector<Double> vec = createVector();
        callRemove(vec);
    }
    
    private static Vector<Double> createVector() {
        Vector<Double> v = new Vector<>();
        v.add(3.14);
        return v;
    }
    
    private static void callRemove(Vector<Double> v) {
        // Type mismatch across method boundaries
        v.removeElement("incompatible"); // [REPORTED LINE]
    }
}