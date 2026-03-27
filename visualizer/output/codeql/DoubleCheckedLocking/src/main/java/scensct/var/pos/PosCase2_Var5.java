// Double-checked locking on non-volatile immutable-type field with field access outside synchronized block should be flagged.
package scensct.var.pos;

public class PosCase2_Var5 {
    private String instance;

    public String getInstance() {
        // Restructured control flow with early return for null after sync
        if (instance != null) {
            return instance; // Early return, but still access outside sync
        }
        synchronized (this) {
            if (instance == null) {
                instance = "done";
            }
        }
        // Field accessed after synchronization block
        return instance;
    }
}