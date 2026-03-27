// A JUnit 5 test class contains an inner class with test methods but the inner class is missing the required @Nested annotation should be flagged as Positive.
package scensct.core.pos;

import org.junit.jupiter.api.Test;

public class PosCase1 {
    // Inner class with @Test method but missing @Nested annotation
    class InnerTestClass { // [REPORTED LINE]
        @Test
        void testMethod() {
            // Test logic that should trigger the checker
        }
    }
}