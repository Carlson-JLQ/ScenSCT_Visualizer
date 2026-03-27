// A JUnit 5 test class containing an inner class annotated with @org.junit.jupiter.api.Nested should not be flagged as missing @Nested.
package scensct.var.neg;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NegCase1_Var1 {
    // Variant 1: Change inner class visibility and add a static nested helper
    private static class UnrelatedHelper { }
    
    @Nested
    public static class InnerTestClass {
        @Test
        void testMethod() {
            // Still correctly annotated
        }
    }
}