// A class that does not override equals(Object) but declares at least one method named hashCode should be flagged as a violation.
package scensct.var.pos;

public class PosCase3_Var5 { // [REPORTED LINE]
    private int id;
    
    @Override
    public int hashCode() {
        int h = id;
        for (int i = 0; i < 1; i++) {
            h = h * 31 + 17;
        }
        return h;
    }
    
    // No equals(Object) defined
}