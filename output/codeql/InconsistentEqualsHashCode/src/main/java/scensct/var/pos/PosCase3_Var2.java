// A class that does not override equals(Object) but declares at least one method named hashCode should be flagged as a violation.
package scensct.var.pos;

public class PosCase3_Var2 { // [REPORTED LINE]
    private int id;
    private String name;
    
    @Override
    public int hashCode() {
        try {
            return id + (name != null ? name.hashCode() : 0);
        } catch (Exception e) {
            return super.hashCode();
        }
    }
    
    // No equals override
}