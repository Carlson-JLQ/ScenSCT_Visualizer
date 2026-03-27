// Logical OR with true literal and non-constant boolean expression inside constructor should be flagged as always true.
package scensct.var.pos;

public class PosCase3_Var3 {
    public PosCase3_Var3() {
        // Inline the non-constant call directly into the OR expression
        boolean result = true || (Math.random() > 0.5); // [REPORTED LINE]
    }
    
    // Keep the method for consistency, though unused
    private boolean getNonConstantBoolean() {
        return Math.random() > 0.5;
    }
}