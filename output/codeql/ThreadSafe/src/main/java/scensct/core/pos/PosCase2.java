// A @ThreadSafe class has a non-volatile, non-thread-safe field with an unsynchronized read and a partially synchronized write should be flagged as improperly synchronized.
package scensct.core.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase2 {
    private int value; // Non-volatile, non-thread-safe field

    public int getValue() {
        return value; // Unsynchronized read // [REPORTED LINE]
    }

    public void setValue(int newValue) {
        synchronized (this) {
            value = newValue; // Synchronized write
        }
    }

    public void unsafeSet(int newValue) {
        value = newValue; // Unsynchronized write (partial synchronization) // [REPORTED LINE]
    }
}