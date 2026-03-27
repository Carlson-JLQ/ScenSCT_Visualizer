// A class annotated @ThreadSafe contains a non-volatile, non-thread-safe field with a public unsynchronized write should be flagged as improperly synchronized.
package scensct.core.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase1 {
    private int counter; // Non-volatile, non-thread-safe field

    public void increment() {
        counter++; // Direct write without synchronization // [REPORTED LINE]
    }
}