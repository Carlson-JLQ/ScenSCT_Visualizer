// A class without the @ThreadSafe annotation contains a non-final, non-static, non-volatile field of a non-thread-safe type, not initialized to a default value should not be flagged as unsafe publication.
package scensct.core.neg;

public class NegCase1 {
    // No @ThreadSafe annotation, so checker should not evaluate this class.
    private Object unsafeField; // Non-final, non-static, non-volatile, non-thread-safe type, no default value assignment.
}