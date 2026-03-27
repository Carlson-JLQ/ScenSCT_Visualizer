// Logical OR with true literal and non-constant boolean expression inside constructor should be flagged as always true.
package scensct.var.pos;

public class PosCase3_Var4 {
    public PosCase3_Var4() {
        boolean condition = getNonConstantBoolean();
        // Wrap the OR expression in a try-catch block, preserving reachability
        try {
            boolean result = true || condition; // [REPORTED LINE]
        } catch (Exception e) {
            // Ignore
        }
    }
    
    private boolean getNonConstantBoolean() {
        return Math.random() > 0.5;
    }
}