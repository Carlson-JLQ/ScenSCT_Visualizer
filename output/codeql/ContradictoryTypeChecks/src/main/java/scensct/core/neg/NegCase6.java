// Variable checked via instanceof for SUP, SSA definition exists but no variable access reads it for cast should not be flagged as contradictory type check.
package scensct.core.neg;

public class NegCase6 {
    public static void main(String[] args) {
        Object obj = "test";
        // Instanceof check for supertype CharSequence (SUP)
        if (obj instanceof CharSequence) {
            // SSA definition from obj exists in this block, but no read for cast
            System.out.println("CharSequence");
        }
        // Later cast uses original obj, not the SSA definition from the instanceof block
        StringBuilder sb = (StringBuilder) obj; // No contradiction: no read of SSA definition
    }
}