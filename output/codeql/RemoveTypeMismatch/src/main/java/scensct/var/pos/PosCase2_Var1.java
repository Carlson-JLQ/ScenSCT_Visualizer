// Call removeElement on a java.util.Vector with an argument of a type that is incompatible with the vector's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.Vector;

public class PosCase2_Var1 {
    public static void main(String[] args) {
        Vector<Double> numbers = new Vector<Double>();
        numbers.add(3.14);
        String wrongArg = "incompatible";
        // Type mismatch preserved via variable
        numbers.removeElement(wrongArg); // [REPORTED LINE]
    }
}