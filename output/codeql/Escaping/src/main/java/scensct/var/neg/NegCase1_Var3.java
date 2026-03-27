// A class without the @ThreadSafe annotation contains a non-final, non-private, non-volatile field should not be flagged as thread-safe concurrency issue.
package scensct.var.neg;

// No import for any thread-safe annotation
public class NegCase1_Var3 {
    // Split declaration and initialization in a method
    int regularField;

    // Constructor that sets the field
    public NegCase1_Var3() {
        regularField = 42;
    }

    // Helper method that returns the field
    int compute() {
        return regularField * 2;
    }

    // Nested static class also without @ThreadSafe, containing a similar field
    static class Inner {
        int innerField;
    }
}