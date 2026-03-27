// A class that overrides hashCode but does not override equals should be flagged as a violation.
package scensct.var.pos;

public class PosCase1_Var4 { // [REPORTED LINE]
    private int id;
    
    // Extracted hashCode logic to a private method
    private int computeHash() {
        return id ^ (id >>> 16); // Simple hash mixing
    }
    
    @Override
    public int hashCode() {
        return computeHash();
    }
    
    // Added a non-overriding equals method with different signature
    public boolean equals(PosCase1_Var4 other) {
        // This is overloaded, not overridden, so doesn't count
        return other != null && this.id == other.id;
    }
    
    // No equals(Object) override
}