// A class annotated @ThreadSafe contains a non-volatile, non-thread-safe field with a public unsynchronized write should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase1_Var1 {
    private int count; // Renamed field

    public void increment() {
        // Refactored increment using a temporary variable
        int temp = count; // [REPORTED LINE]
        temp = temp + 1;
        count = temp; // Unsynchronized write // [REPORTED LINE]
    }
}