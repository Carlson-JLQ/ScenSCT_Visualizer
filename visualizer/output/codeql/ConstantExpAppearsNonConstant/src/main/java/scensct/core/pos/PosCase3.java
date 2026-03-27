// Logical OR with true literal and non-constant boolean expression inside constructor should be flagged as always true.
package scensct.core.pos;

public class PosCase3 {
    public PosCase3() {
        boolean condition = getNonConstantBoolean(); // Non-constant boolean expression
        boolean result = true || condition; // Always true due to true literal // [REPORTED LINE]
    }
    
    private boolean getNonConstantBoolean() {
        return Math.random() > 0.5; // Non-constant boolean
    }
}