// A class annotated @ThreadSafe contains a non-thread-safe field with no public write access should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.HashSet;
import java.util.Set;

public class NegCase4_Var3 {
    @ThreadSafe
    static class TestClass {
        private final Set<String> storage = new HashSet<>();
        private final Object rLock = new Object();
        private final Object wLock = new Object();
        
        private Set<String> getStorage() {
            return storage;
        }
        
        private void privateAdd(String entry) {
            Object lock = wLock;
            synchronized (lock) {
                getStorage().add(entry);
            }
        }
        
        public boolean contains(String key) {
            synchronized (rLock) {
                boolean result;
                result = storage.contains(key);
                return result;
            }
        }
    }
    
    @interface ThreadSafe {}
}