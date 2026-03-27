// Logical OR with true literal and non-constant boolean expression inside constructor should be flagged as always true.
package scensct.var.pos;

public class PosCase3_Var1 {
    public PosCase3_Var1() {
        boolean condition = getNonConstantBoolean();
        // Use Boolean.TRUE and explicit parentheses
        boolean result = (Boolean.TRUE) || condition;
    }
    
    private boolean getNonConstantBoolean() {
        return Math.random() > 0.5;
    }
}