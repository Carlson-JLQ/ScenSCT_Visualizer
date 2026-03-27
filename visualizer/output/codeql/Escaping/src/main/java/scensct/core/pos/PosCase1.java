// A class annotated with @ThreadSafe contains a non-final, non-private, non-volatile instance field should be flagged as a concurrency issue.
package scensct.core.pos;

// Simulating a thread-safe annotation. In a real checker, this would be a known annotation (e.g., from a concurrency library).
@interface ThreadSafe {}

@ThreadSafe
public class PosCase1 {
    // Non-final, non-private, non-volatile instance field - this should trigger the checker.
    int unsafeCounter; // [REPORTED LINE]
}