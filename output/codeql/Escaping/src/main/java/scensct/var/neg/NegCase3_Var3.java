// A class annotated with @ThreadSafe contains a field that is inherited from a superclass or accessed from another class, not declared directly in the annotated class should not be flagged as thread-safe concurrency issue.
package scensct.var.neg;

import com.exp.ThreadSafe;

// Superclass with default visibility
class Ancestor {
    int data; // Non-final, non-private, non-volatile
}

@ThreadSafe
public class NegCase3_Var3 extends Ancestor {
    // Control-flow restructuring: access in a loop
    void method() {
        int sum = 0;
        for (int i = 0; i < 1; i++) {
            sum += data; // Access inside loop
        }
        int value = sum;
    }
}