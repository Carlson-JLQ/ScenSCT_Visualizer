// A class annotated @ThreadSafe contains a non-volatile, non-thread-safe field with a public unsynchronized write should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase1_Var3 {
    private int counter;

    // Helper method that performs the unsynchronized write
    private void unsafeIncrement() {
        counter++; // [REPORTED LINE]
    }

    public void increment() {
        // Public method delegates to private helper
        unsafeIncrement(); // Unsynchronized write via call
    }
}