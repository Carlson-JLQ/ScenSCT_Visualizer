// A JUnit 5 test class containing an inner class annotated with @org.junit.jupiter.api.Nested should not be flagged as missing @Nested.
package scensct.var.neg;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NegCase1_Var5 {
    // Variant 5: Inner class implements an interface, has constructor, still @Nested
    @Nested
    class InnerTestClass implements Runnable {
        InnerTestClass() {}
        
        @Override
        public void run() {}
        
        @Test
        void testMethod() {
            // correct
        }
    }
}