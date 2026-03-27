// A class that overrides hashCode but does not override equals should be flagged as a violation.
package scensct.var.pos;

import java.util.Objects;

public class PosCase1_Var1 { // [REPORTED LINE]
    private final int id;
    private String name; // Added extra field, not used in hashCode
    
    public PosCase1_Var1(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    @Override
    public int hashCode() {
        // Slightly more complex implementation, still based only on id
        int result = 17;
        result = 31 * result + id;
        return result;
    }
    
    // Still no equals method
}