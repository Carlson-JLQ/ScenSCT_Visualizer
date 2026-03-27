// A class annotated @ThreadSafe contains a non-volatile, non-thread-safe field with a public unsynchronized write should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase1_Var2 {
    private long accumulator; // Changed type, still non-volatile

    public void addOne() {
        // Restructured control flow with a loop that executes once
        for (int i = 0; i < 1; i++) {
            accumulator = accumulator + 1L; // Unsynchronized write // [REPORTED LINE]
        }
    }
}