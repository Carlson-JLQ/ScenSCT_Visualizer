// A class that does not override equals(Object) but declares at least one method named hashCode should be flagged as a violation.
package scensct.ref.pos;

public class PosCase3_FN1 {
    private int id;
    
    // This method is named hashCode but does not override Object.hashCode due to different signature.
    public int hashCode(int seed) {
        return id + seed;
    }
    // No equals method overridden, violating the contract.
}