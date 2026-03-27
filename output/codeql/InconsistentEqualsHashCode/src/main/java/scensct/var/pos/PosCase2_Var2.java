// A class that overrides equals (non-refining) but does not override hashCode should be flagged as a violation.
package scensct.var.pos;

public class PosCase2_Var2 { // [REPORTED LINE]
    private int id;
    private String name; // extra field not used in equals
    
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        PosCase2_Var2 other = (PosCase2_Var2) o;
        boolean result = this.id == other.id;
        return result;
    }
    
    public void someMethod() {
        // unrelated method to add noise
        System.out.println("Unrelated");
    }
    
    // Still no hashCode.
}