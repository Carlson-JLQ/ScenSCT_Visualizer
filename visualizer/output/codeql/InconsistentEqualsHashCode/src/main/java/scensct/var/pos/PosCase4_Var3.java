// A class that does not override hashCode() but declares at least one method named equals should be flagged as a violation.
package scensct.var.pos;

public class PosCase4_Var3 { // [REPORTED LINE]
    private int id;
    
    public boolean equals(Object o) {
        return isEqual(o);
    }
    
    private boolean isEqual(Object obj) {
        if (obj instanceof PosCase4_Var3 p) {
            return this.id == p.id;
        }
        return false;
    }
}