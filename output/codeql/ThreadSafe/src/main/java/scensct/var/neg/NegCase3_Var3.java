// A class annotated @ThreadSafe contains a non-thread-safe field with all public accesses locked should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.HashMap;
import java.util.Map;

public class NegCase3_Var3 {
    @ThreadSafe
    static class TestClass {
        private final Object monitor = new Object();
        private Map<Integer, String> map = new HashMap<>(); // Non-thread-safe field
        
        private <T> T withLock(java.util.function.Supplier<T> action) {
            synchronized (monitor) {
                return action.get();
            }
        }
        
        public void put(int key, String value) {
            withLock(() -> {
                map.put(key, value);
                return null;
            });
        }
        
        public String get(int key) {
            return withLock(() -> map.get(key));
        }
    }
    
    @interface ThreadSafe {}
}