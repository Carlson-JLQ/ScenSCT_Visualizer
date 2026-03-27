// A class that overrides equals (non-refining) but does not override hashCode should be flagged as a violation.
package scensct.var.pos;

public class PosCase2_Var1 { // [REPORTED LINE]
    private final long identifier;
    
    public PosCase2_Var1(long id) {
        this.identifier = id;
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof PosCase2_Var1)) return false;
        PosCase2_Var1 that = (PosCase2_Var1) other;
        return this.identifier == that.identifier;
    }
    
    // hashCode is still missing, violation remains.
}