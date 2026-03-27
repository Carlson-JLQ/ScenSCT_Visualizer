// A class that overrides equals (non-refining) but does not override hashCode should be flagged as a violation.
package scensct.var.pos;

public class PosCase2_Var5 { // [REPORTED LINE]
    private int id;
    private transient int cache; // transient field, irrelevant
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof PosCase2_Var5)) return false;
        PosCase2_Var5 that = (PosCase2_Var5) obj;
        return this.id == that.id;
    }
    
    // hashCode absent.
}