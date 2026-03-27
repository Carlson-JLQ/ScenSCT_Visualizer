// A class annotated @ThreadSafe contains a non-thread-safe field with all public accesses locked should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class NegCase3_Var2 {
    @ThreadSafe
    static class TestClass {
        private final ReentrantLock lock = new ReentrantLock();
        private Map<Integer, String> map = new HashMap<>(); // Non-thread-safe field
        
        public void put(int key, String value) {
            lock.lock();
            try {
                map.put(key, value);
            } finally {
                lock.unlock();
            }
        }
        
        public String get(int key) {
            lock.lock();
            try {
                return map.get(key);
            } finally {
                lock.unlock();
            }
        }
    }
    
    @interface ThreadSafe {}
}