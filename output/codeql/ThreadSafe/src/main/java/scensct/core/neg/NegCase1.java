// A class annotated @ThreadSafe contains a field whose type is a thread-safe type should not be flagged as improperly synchronized.
package scensct.core.neg;

import java.util.concurrent.atomic.AtomicInteger;

public class NegCase1 {
    @ThreadSafe
    static class TestClass {
        // Thread-safe field type
        private final AtomicInteger counter = new AtomicInteger(0);
        
        public int getCounter() {
            return counter.get();
        }
    }
    
    // Placeholder annotation for compilation
    @interface ThreadSafe {}
}