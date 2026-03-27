// A class that does not override hashCode() but declares at least one method named equals should be flagged as a violation.
package scensct.var.pos;

public class PosCase4_Var5 { // [REPORTED LINE]
    private int id;
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final PosCase4_Var5 other = (PosCase4_Var5) obj;
        boolean areEqual = this.id == other.id;
        return areEqual;
    }
}