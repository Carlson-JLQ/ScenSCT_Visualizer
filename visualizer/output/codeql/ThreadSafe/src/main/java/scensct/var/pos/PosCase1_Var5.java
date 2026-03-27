// A class annotated @ThreadSafe contains a non-volatile, non-thread-safe field with a public unsynchronized write should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase1_Var5 {
    private int counter;

    public void increment() {
        // Using try-finally without synchronization
        try {
            // Write in try block
            counter = counter + 1; // [REPORTED LINE]
        } finally {
            // No-op finally, no synchronization
        }
    }
}