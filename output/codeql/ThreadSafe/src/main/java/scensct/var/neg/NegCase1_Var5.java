// A class annotated @ThreadSafe contains a field whose type is a thread-safe type should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.concurrent.atomic.AtomicInteger;

public class NegCase1_Var5 {
    @ThreadSafe
    static class TestClass {
        // Change to a different thread-safe atomic type with similar semantics
        private final AtomicInteger counter = new AtomicInteger(0);
        
        public int getCounter() {
            // Use incrementAndGet and decrementAndGet to maintain same value
            counter.incrementAndGet();
            int val = counter.decrementAndGet();
            return val;
        }
    }
    
    @interface ThreadSafe {}
}