// A class that overrides hashCode but does not override equals should be flagged as a violation.
package scensct.var.pos;

public class PosCase1_Var2 { // [REPORTED LINE]
    private int id;
    private transient int cache; // Added transient field
    
    // Added static initializer (irrelevant)
    static {
        System.out.println("Class loaded");
    }
    
    @Override
    public int hashCode() {
        // Using a local variable and conditional
        int h = id;
        if (h < 0) {
            h = -h;
        }
        return h;
    }
    
    public void setId(int id) { // Added setter
        this.id = id;
    }
    
    // No equals override
}