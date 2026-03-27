// A class that overrides hashCode but does not override equals should be flagged as a violation.
package scensct.core.pos;

public class PosCase1 { // [REPORTED LINE]
    private int id;
    
    @Override
    public int hashCode() {
        return id;
    }
    // No equals method overridden, violating the contract.
}