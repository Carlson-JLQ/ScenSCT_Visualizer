// A class annotated @ThreadSafe contains a field whose type is a thread-safe type should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.concurrent.atomic.AtomicInteger;

public class NegCase1_Var2 {
    @ThreadSafe
    static class TestClass {
        private final AtomicInteger counter;
        
        // Initialize in constructor instead of direct assignment
        TestClass() {
            counter = new AtomicInteger(0);
        }
        
        public int getCounter() {
            // Access via a conditional branch (dead code)
            if (true) {
                return counter.get();
            }
            return -1; // Unreachable
        }
    }
    
    @interface ThreadSafe {}
}