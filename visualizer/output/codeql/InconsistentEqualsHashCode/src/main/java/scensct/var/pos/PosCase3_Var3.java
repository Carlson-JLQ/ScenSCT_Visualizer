// A class that does not override equals(Object) but declares at least one method named hashCode should be flagged as a violation.
package scensct.var.pos;

public class PosCase3_Var3 { // [REPORTED LINE]
    private int id;
    
    // Override hashCode but not equals
    @Override
    public int hashCode() {
        return computeHash();
    }
    
    private int computeHash() {
        return id ^ (id >>> 16);
    }
    
    // equals is absent
}