// A class annotated @ThreadSafe contains a non-thread-safe field with all public accesses locked should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.HashMap;
import java.util.Map;

public class NegCase3_Var1 {
    @ThreadSafe
    static class TestClass {
        private Map<Integer, String> map; // Non-thread-safe field, lazy init
        
        public void put(int key, String value) {
            synchronized (this) {
                if (map == null) map = new HashMap<>();
                map.put(key, value);
            }
        }
        
        public String get(int key) {
            synchronized (this) {
                return map == null ? null : map.get(key);
            }
        }
    }
    
    @interface ThreadSafe {}
}