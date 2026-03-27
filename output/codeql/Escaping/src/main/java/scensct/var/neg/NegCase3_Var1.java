// A class annotated with @ThreadSafe contains a field that is inherited from a superclass or accessed from another class, not declared directly in the annotated class should not be flagged as thread-safe concurrency issue.
package scensct.var.neg;

import com.exp.ThreadSafe;

// Superclass without @ThreadSafe annotation
abstract class BaseClass {
    protected int baseField; // Renamed, same non-final, non-private, non-volatile
}

@ThreadSafe
public class NegCase3_Var1 extends BaseClass {
    // Access inherited field via a temporary variable
    void method() {
        int temp = baseField; // Store in local
        int value = temp + 0; // Use it
    }
}