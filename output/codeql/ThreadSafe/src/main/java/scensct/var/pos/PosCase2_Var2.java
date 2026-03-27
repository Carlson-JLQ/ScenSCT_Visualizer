// A @ThreadSafe class has a non-volatile, non-thread-safe field with an unsynchronized read and a partially synchronized write should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase2_Var2 {
    private int value;

    public int getValue() {
        int temp = value; // Introduce temporary variable // [REPORTED LINE]
        return temp; // Unsynchronized read
    }

    public void setValue(int newValue) {
        synchronized (this) {
            value = newValue;
        }
    }

    public void unsafeSet(int newValue) {
        if (newValue >= 0) { // Add irrelevant branching
            value = newValue; // [REPORTED LINE]
        } else {
            value = 0; // [REPORTED LINE]
        } // Unsynchronized write in both branches
    }
}