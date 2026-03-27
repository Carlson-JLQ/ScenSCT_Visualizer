// A class annotated with @ThreadSafe contains a field that is inherited from a superclass or accessed from another class, not declared directly in the annotated class should not be flagged as thread-safe concurrency issue.
package scensct.var.neg;

import com.exp.ThreadSafe;

// Superclass with field accessed via interface
interface IReadable {
    // No fields
}

class Super implements IReadable {
    int sharedField; // Non-final, non-private, non-volatile
}

@ThreadSafe
public class NegCase3_Var5 extends Super {
    // Access inherited field after a null check (no effect)
    void method() {
        if (this != null) {
            int value = sharedField; // Same inherited access
        }
    }
}