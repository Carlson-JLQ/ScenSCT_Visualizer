// A class annotated @ThreadSafe contains a field whose type is a thread-safe type should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.concurrent.atomic.AtomicInteger;

public class NegCase1_Var3 {
    @ThreadSafe
    static class TestClass {
        private final AtomicInteger counter = new AtomicInteger(0);
        
        // Extract access to a private helper method
        public int getCounter() {
            return readCounter();
        }
        
        private int readCounter() {
            return counter.get();
        }
    }
    
    @interface ThreadSafe {}
}