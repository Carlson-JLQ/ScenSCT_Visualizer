// A JUnit 5 test class containing an inner class annotated with @org.junit.jupiter.api.Nested should not be flagged as missing @Nested.
package scensct.var.neg;

// Import with wildcard - checker must still resolve annotation
import org.junit.jupiter.api.*;

public class NegCase1_Var2 {
    // Variant 2: Add an intermediate nesting level without @Nested
    class Middle {
        @Nested
        class InnerTestClass {
            @Test
            void testMethod() { }
        }
    }
}