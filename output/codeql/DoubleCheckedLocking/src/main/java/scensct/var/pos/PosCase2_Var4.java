// Double-checked locking on non-volatile immutable-type field with field access outside synchronized block should be flagged.
package scensct.var.pos;

public class PosCase2_Var4 {
    private String instance;

    public String getInstance() {
        try {
            if (instance == null) {
                synchronized (this) { // [REPORTED LINE]
                    if (instance == null) {
                        instance = "value";
                    }
                }
            }
        } finally {
            // Control flow with try-finally, but no suppression
        }
        String output = instance; // Access in separate statement
        return output;
    }
}