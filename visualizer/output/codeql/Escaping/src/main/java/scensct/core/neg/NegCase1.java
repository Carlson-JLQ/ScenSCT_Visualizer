// A class without the @ThreadSafe annotation contains a non-final, non-private, non-volatile field should not be flagged as thread-safe concurrency issue.
package scensct.core.neg;

public class NegCase1 {
    // Non-final, non-private, non-volatile field in a class without @ThreadSafe annotation
    int regularField; // Scenario 1: field should not trigger checker as class lacks annotation
}