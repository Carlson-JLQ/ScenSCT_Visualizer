// A JUnit 5 test class containing an inner class annotated with @org.junit.jupiter.api.Nested should not be flagged as missing @Nested.
package scensct.var.neg;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NegCase1_Var3 {
    // Variant 3: Annotated inner class inside a method? No, that's not valid.
    // Instead: wrap @Nested in a redundant annotation array (still single effective)
    @Nested
    @Deprecated // extra annotation, irrelevant
    class InnerTestClass {
        @Test
        void testMethod() {
            if (Math.random() > 2) return; // dead code, shouldn't affect detection
        }
    }
}