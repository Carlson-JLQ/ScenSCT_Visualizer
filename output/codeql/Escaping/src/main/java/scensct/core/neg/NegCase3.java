// A class annotated with @ThreadSafe contains a field that is inherited from a superclass or accessed from another class, not declared directly in the annotated class should not be flagged as thread-safe concurrency issue.
package scensct.core.neg;

import com.exp.ThreadSafe;

// Superclass without @ThreadSafe annotation
class SuperClass {
    int inheritedField; // Non-final, non-private, non-volatile field in superclass
}

@ThreadSafe
public class NegCase3 extends SuperClass {
    // Scenario 3: inheritedField is not declared directly in @ThreadSafe class
    // Checker should not flag inherited fields from superclass
    void method() {
        int value = inheritedField; // Access inherited field
    }
}