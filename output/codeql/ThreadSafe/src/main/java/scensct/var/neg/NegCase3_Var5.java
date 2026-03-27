// A class annotated @ThreadSafe contains a non-thread-safe field with all public accesses locked should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.HashMap;
import java.util.Map;

public class NegCase3_Var5 {
    @ThreadSafe
    static class TestClass {
        private final Object sync = new Object();
        private Map<Integer, String> map = new HashMap<>(); // Non-thread-safe field
        
        private void unsafePut(int key, String value) {
            map.put(key, value);
        }
        
        private String unsafeGet(int key) {
            return map.get(key);
        }
        
        public void put(int key, String value) {
            synchronized (sync) {
                unsafePut(key, value);
            }
        }
        
        public String get(int key) {
            synchronized (sync) {
                return unsafeGet(key);
            }
        }
    }
    
    @interface ThreadSafe {}
}