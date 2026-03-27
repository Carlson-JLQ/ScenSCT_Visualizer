// A class annotated @ThreadSafe contains a field whose type is a thread-safe type should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.concurrent.atomic.AtomicInteger;

public class NegCase1_Var1 {
    @ThreadSafe
    static class TestClass {
        // Renamed field, still final and thread-safe
        private final AtomicInteger atomicCount = new AtomicInteger(0);
        
        public int getCounter() {
            // Introduce a temporary variable
            int result = atomicCount.get();
            return result;
        }
    }
    
    @interface ThreadSafe {}
}