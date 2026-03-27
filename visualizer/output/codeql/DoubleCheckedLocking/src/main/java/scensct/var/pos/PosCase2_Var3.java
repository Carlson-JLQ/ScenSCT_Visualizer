// Double-checked locking on non-volatile immutable-type field with field access outside synchronized block should be flagged.
package scensct.var.pos;

public class PosCase2_Var3 {
    private String instance;

    public String getInstance() {
        if (isNotInitialized()) { // Outer check extracted to helper
            initializeSafely();
        }
        return retrieveInstance(); // Access extracted to helper
    }

    private boolean isNotInitialized() {
        return instance == null;
    }

    private void initializeSafely() {
        synchronized (this) {
            if (instance == null) {
                instance = "lazy";
            }
        }
    }

    private String retrieveInstance() {
        return instance; // Access outside synchronized block
    }
}