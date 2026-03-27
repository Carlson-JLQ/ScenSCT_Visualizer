// A class annotated with @ThreadSafe declares a field that is final, private, or volatile should not be flagged as thread-safe concurrency issue.
package scensct.core.neg;

// Assume @ThreadSafe annotation is available from external library
import com.exp.ThreadSafe;

@ThreadSafe
public class NegCase2 {
    private int privateField; // Scenario 2: private field - should not trigger
    final int finalField = 0; // Scenario 2: final field - should not trigger
    volatile int volatileField; // Scenario 2: volatile field - should not trigger
}