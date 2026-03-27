// A JUnit 5 test class containing an inner class annotated with @org.junit.jupiter.api.Nested should not be flagged as missing @Nested.
package scensct.var.neg;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NegCase1_Var4 {
    // Variant 4: Extract @Nested annotation to a separate line for clarity
    @Nested
    final class InnerTestClass {
        @Test
        void testMethod() {
            // empty
        }
        
        @Test
        void anotherTest() { } // multiple test methods
    }
    
    void unrelatedMethod() {
        // noise
    }
}