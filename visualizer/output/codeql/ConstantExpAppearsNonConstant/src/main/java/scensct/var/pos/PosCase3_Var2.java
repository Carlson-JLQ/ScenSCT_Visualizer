// Logical OR with true literal and non-constant boolean expression inside constructor should be flagged as always true.
package scensct.var.pos;

public class PosCase3_Var2 {
    public PosCase3_Var2() {
        boolean condition = getNonConstantBoolean();
        // Introduce a temporary variable for true
        final boolean alwaysTrue = true;
        boolean result = alwaysTrue || condition;
    }
    
    private boolean getNonConstantBoolean() {
        return Math.random() > 0.5;
    }
}