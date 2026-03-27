// A class with synchronized setter and unsynchronized getter, getter accesses volatile field but no write to it exists should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase4_Var2 {
    private volatile int status;
    private int value;

    // Synchronized setter with additional non-volatile logic
    public synchronized void setValue(int v) {
        if (v >= 0) { // Added control flow
            value = v;
        } else {
            value = 0;
        }
        // Still no write to volatile
    }

    // Unsynchronized getter wrapped in try-finally for cleanup simulation
    public int getValue() { // [REPORTED LINE]
        try {
            return value; // Core access
        } finally {
            // No-op, preserves behavior
        }
    }

    // Volatile field getter with temporary variable
    public int getStatus() {
        int temp = status; // Read via temporary
        return temp;
    }
}