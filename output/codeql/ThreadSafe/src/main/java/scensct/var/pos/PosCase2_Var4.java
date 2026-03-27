// A @ThreadSafe class has a non-volatile, non-thread-safe field with an unsynchronized read and a partially synchronized write should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase2_Var4 {
    private int value;

    public int getValue() {
        try {
            return value; // Unsynchronized read in try block // [REPORTED LINE]
        } finally {
            // No-op finally
        }
    }

    public void setValue(int newValue) {
        Object lock = this;
        synchronized (lock) { // Different lock expression, same monitor
            value = newValue;
        }
    }

    public void unsafeSet(int newValue) {
        for (int i = 0; i < 1; i++) { // Loop that executes once
            value = newValue; // Unsynchronized write inside loop // [REPORTED LINE]
        }
    }
}