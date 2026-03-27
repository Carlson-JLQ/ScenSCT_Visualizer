// A class annotated @ThreadSafe contains a non-thread-safe field with all public accesses locked should not be flagged as improperly synchronized.
package scensct.core.neg;

import java.util.HashMap;
import java.util.Map;

public class NegCase3 {
    @ThreadSafe
    static class TestClass {
        private final Object monitor = new Object();
        private Map<Integer, String> map = new HashMap<>(); // Non-thread-safe field
        
        public void put(int key, String value) {
            synchronized (monitor) {
                map.put(key, value);
            }
        }
        
        public String get(int key) {
            synchronized (monitor) {
                return map.get(key);
            }
        }
    }
    
    @interface ThreadSafe {}
}