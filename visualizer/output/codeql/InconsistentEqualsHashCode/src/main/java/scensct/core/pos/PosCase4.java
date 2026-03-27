// A class that does not override hashCode() but declares at least one method named equals should be flagged as a violation.
package scensct.core.pos;

public class PosCase4 { // [REPORTED LINE]
    private int id;
    
    // This method overrides Object.equals.
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PosCase4) {
            return this.id == ((PosCase4) obj).id;
        }
        return false;
    }
    // No hashCode method overridden, violating the contract.
}