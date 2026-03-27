// A class that does not override equals(Object) but declares at least one method named hashCode should be flagged as a violation.
package scensct.core.pos;

public class PosCase3 { // [REPORTED LINE]
    private int id;
    
    // This method overrides Object.hashCode.
    @Override
    public int hashCode() {
        return id;
    }
    // No equals method overridden, violating the contract.
}