// A class that overrides equals (non-refining) but does not override hashCode should be flagged as a violation.
package scensct.var.pos;

public class PosCase2_Var3 { // [REPORTED LINE]
    private int id;
    
    private boolean areIdsEqual(PosCase2_Var3 a, PosCase2_Var3 b) {
        return a.id == b.id;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PosCase2_Var3 other) {
            return areIdsEqual(this, other);
        }
        return false;
    }
    
    // No hashCode override.
}