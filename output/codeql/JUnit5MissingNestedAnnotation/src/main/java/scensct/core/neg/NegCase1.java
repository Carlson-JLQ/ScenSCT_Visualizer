// A JUnit 5 test class containing an inner class annotated with @org.junit.jupiter.api.Nested should not be flagged as missing @Nested.
package scensct.core.neg;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NegCase1 {
    @Nested
    class InnerTestClass {
        @Test
        void testMethod() {
            // Inner class is correctly annotated with @Nested
        }
    }
}