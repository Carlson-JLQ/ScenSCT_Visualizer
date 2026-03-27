// A class that does not override hashCode() but declares at least one method named equals should be flagged as a violation.
package scensct.var.pos;

public class PosCase4_Var4 { // [REPORTED LINE]
    private int id;
    
    @Override
    public boolean equals(Object obj) {
        try {
            PosCase4_Var4 other = (PosCase4_Var4) obj;
            return this.id == other.id;
        } catch (ClassCastException e) {
            return false;
        }
    }
}