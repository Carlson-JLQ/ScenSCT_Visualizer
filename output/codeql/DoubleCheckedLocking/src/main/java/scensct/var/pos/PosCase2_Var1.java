// Double-checked locking on non-volatile immutable-type field with field access outside synchronized block should be flagged.
package scensct.var.pos;

public class PosCase2_Var1 {
    private String data; // Renamed field, still non-volatile and immutable type

    public String getInstance() {
        String localRef = data; // Introduce temporary variable for outer check
        if (localRef == null) {
            synchronized (this) { // [REPORTED LINE]
                if (data == null) {
                    data = "configured"; // Different initialization value
                }
            }
        }
        return data; // Access outside synchronized block
    }
}