// A class annotated @ThreadSafe contains a non-thread-safe field with no public write access should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class NegCase4_Var1 {
    @ThreadSafe
    static class TestClass {
        private final Set<String> data = new HashSet<>();
        private final Object accessGuard = new Object();
        private final ReentrantLock modificationLock = new ReentrantLock();
        
        private void insert(String element) {
            modificationLock.lock();
            try {
                data.add(element);
            } finally {
                modificationLock.unlock();
            }
        }
        
        public boolean hasItem(String item) {
            synchronized (accessGuard) {
                return data.contains(item);
            }
        }
    }
    
    @interface ThreadSafe {}
}