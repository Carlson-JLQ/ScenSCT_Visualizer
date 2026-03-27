// A class that does not override hashCode() but declares at least one method named equals should be flagged as a violation.
package scensct.ref.pos;

public class PosCase4_FN1 {
    private int id;
    
    // This method is named equals but does not override Object.equals due to different parameter type.
    public boolean equals(PosCase4_FN1 other) {
        return this.id == other.id;
    }
    // No hashCode method overridden, violating the contract.
}