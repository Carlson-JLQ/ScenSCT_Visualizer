// Double-checked locking on non-volatile immutable-type field with field access outside synchronized block should be flagged.
package scensct.core.pos;

public class PosCase2 {
    private String instance; // Non-volatile field of immutable type String

    public String getInstance() {
        if (instance == null) { // Outer null check
            synchronized (this) { // [REPORTED LINE]
                if (instance == null) { // Inner null check
                    instance = "initialized"; // Initialization inside synchronized block
                }
            }
        }
        // Field accessed outside synchronized block (zero or more times)
        return instance; // One access outside
    }
}