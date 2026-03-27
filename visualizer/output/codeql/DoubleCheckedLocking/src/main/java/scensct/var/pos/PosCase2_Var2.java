// Double-checked locking on non-volatile immutable-type field with field access outside synchronized block should be flagged.
package scensct.var.pos;

public class PosCase2_Var2 {
    private Integer count; // Changed to another immutable type (Integer)

    public String getInstance() {
        if (count == null) {
            Object lock = this; // Alias for lock object
            synchronized (lock) { // [REPORTED LINE]
                if (count == null) {
                    count = 42; // Initialization with Integer
                }
            }
        }
        // Multiple accesses outside synchronized block
        Integer result = count;
        return result.toString(); // Access via temporary and method call
    }
}