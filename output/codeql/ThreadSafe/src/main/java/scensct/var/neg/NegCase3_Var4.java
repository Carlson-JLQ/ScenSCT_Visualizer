// A class annotated @ThreadSafe contains a non-thread-safe field with all public accesses locked should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.HashMap;
import java.util.Map;

public class NegCase3_Var4 {
    @ThreadSafe
    static class TestClass {
        private final Object lock = new Object();
        private Map<Integer, String> data = new HashMap<>(); // Non-thread-safe field // [REPORTED LINE]
        
        public void put(int key, String value) {
            Object mutex = lock; // alias
            synchronized (mutex) {
                data.put(key, value);
            }
        }
        
        public String get(int key) {
            Map<Integer, String> localRef;
            synchronized (lock) {
                localRef = data;
            }
            // Access after release? No — still inside? Wait, this breaks the invariant.
            // Correction: keep access inside synchronized.
            synchronized (lock) {
                return data.get(key);
            }
        }
    }
    
    @interface ThreadSafe {}
}