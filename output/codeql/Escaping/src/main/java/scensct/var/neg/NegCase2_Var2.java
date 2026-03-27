// A class annotated with @ThreadSafe declares a field that is final, private, or volatile should not be flagged as thread-safe concurrency issue.
package scensct.var.neg;

import com.exp.ThreadSafe;

@ThreadSafe
public class NegCase2_Var2 {
    private int privateField;
    final int finalField;
    volatile int volatileField;

    // Static initializer for demonstration (no effect on rule)
    static {
        // No rule-violating fields here
    }

    // Inner class also annotated @ThreadSafe with safe fields
    @ThreadSafe
    static class Inner {
        private int innerPrivate;
        final int innerFinal = 1;
    }

    public NegCase2_Var2() {
        finalField = 42; // final assigned in constructor
    }
}