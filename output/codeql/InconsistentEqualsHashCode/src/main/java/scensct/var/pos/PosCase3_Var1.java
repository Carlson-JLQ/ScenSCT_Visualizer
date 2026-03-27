// A class that does not override equals(Object) but declares at least one method named hashCode should be flagged as a violation.
package scensct.var.pos;

public class PosCase3_Var1 { // [REPORTED LINE]
    private final int id = 42;
    
    @Override
    public int hashCode() {
        int result = id;
        // Simple arithmetic to compute hash
        return result * 31;
    }
    
    // Still missing equals
}