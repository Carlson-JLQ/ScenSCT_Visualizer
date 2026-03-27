// A class that does not override equals(Object) but declares at least one method named hashCode should be flagged as a violation.
package scensct.var.pos;

public class PosCase3_Var4 { // [REPORTED LINE]
    private int id;
    private transient int cache;
    
    @Override
    public int hashCode() {
        if (cache == 0) {
            cache = id;
        }
        return cache;
    }
    
    // Missing equals method
}