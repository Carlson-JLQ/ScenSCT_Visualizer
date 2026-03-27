// A class that overrides equals (non-refining) but does not override hashCode should be flagged as a violation.
package scensct.var.pos;

public class PosCase2_Var4 { // [REPORTED LINE]
    private int id;
    
    @Override
    public boolean equals(Object obj) {
        try {
            PosCase2_Var4 other = (PosCase2_Var4) obj;
            return this.id == other.id;
        } catch (ClassCastException e) {
            return false;
        }
    }
    
    // Missing hashCode.
}