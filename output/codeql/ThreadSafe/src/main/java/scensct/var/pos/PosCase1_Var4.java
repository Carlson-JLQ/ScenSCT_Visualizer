// A class annotated @ThreadSafe contains a non-volatile, non-thread-safe field with a public unsynchronized write should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase1_Var4 {
    private int counter;

    public void increment() {
        // Added dead code and conditional that always executes
        if (true) {
            counter += 1; // Equivalent unsynchronized write // [REPORTED LINE]
        } else {
            // Dead branch
            System.out.println("unreachable");
        }
    }
}