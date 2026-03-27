// A class annotated @ThreadSafe contains a field whose type is a thread-safe type should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class NegCase1_Var4 {
    @ThreadSafe
    static class TestClass {
        private final AtomicInteger counter = new AtomicInteger(0);
        
        public int getCounter() {
            // Use a lambda to access the field (still thread-safe)
            Supplier<Integer> supplier = () -> counter.get();
            return supplier.get();
        }
    }
    
    @interface ThreadSafe {}
}