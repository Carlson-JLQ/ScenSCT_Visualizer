// A class annotated @ThreadSafe contains a non-thread-safe field with all accesses protected by the same lock should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class NegCase2_Var1 {
    @ThreadSafe
    static class TestClass {
        private final ReentrantLock lock = new ReentrantLock();
        private List<String> data = new ArrayList<>();
        
        public void add(String item) {
            lock.lock();
            try {
                data.add(item);
            } finally {
                lock.unlock();
            }
        }
        
        public List<String> getAll() {
            lock.lock();
            try {
                return new ArrayList<>(data);
            } finally {
                lock.unlock();
            }
        }
    }
    
    @interface ThreadSafe {}
}