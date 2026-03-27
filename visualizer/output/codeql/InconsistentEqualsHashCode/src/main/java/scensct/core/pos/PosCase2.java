// A class that overrides equals (non-refining) but does not override hashCode should be flagged as a violation.
package scensct.core.pos;

public class PosCase2 { // [REPORTED LINE]
    private int id;
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PosCase2) {
            return this.id == ((PosCase2) obj).id;
        }
        return false;
    }
    // No hashCode method overridden, violating the contract.
}