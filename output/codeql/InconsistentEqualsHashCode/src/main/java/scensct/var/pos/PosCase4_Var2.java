// A class that does not override hashCode() but declares at least one method named equals should be flagged as a violation.
package scensct.var.pos;

public class PosCase4_Var2 { // [REPORTED LINE]
    private int id;
    private String tag;
    
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null && obj.getClass() == this.getClass()) {
            PosCase4_Var2 other = (PosCase4_Var2) obj;
            result = (this.id == other.id);
        }
        return result;
    }
}