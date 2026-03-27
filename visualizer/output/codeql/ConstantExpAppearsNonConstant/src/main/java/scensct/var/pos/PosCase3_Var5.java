// Logical OR with true literal and non-constant boolean expression inside constructor should be flagged as always true.
package scensct.var.pos;

public class PosCase3_Var5 {
    public PosCase3_Var5() {
        boolean condition = getNonConstantBoolean();
        // Extract the OR expression into a private helper method
        boolean result = alwaysTrueOr(condition);
    }
    
    private boolean getNonConstantBoolean() {
        return Math.random() > 0.5;
    }
    
    private boolean alwaysTrueOr(boolean cond) {
        return true || cond; // [REPORTED LINE]
    }
}