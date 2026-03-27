// A class annotated @ThreadSafe contains a non-thread-safe field with all accesses protected by the same lock should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.List;

public class NegCase2_Var5 {
    @ThreadSafe
    static class TestClass {
        private final Object lock = new Object();
        private List<String> data = new ArrayList<>();
        
        public void add(String item) {
            synchronized (lock) {
                List<String> local = data;
                local.add(item);
            }
        }
        
        public List<String> getAll() {
            // Additional synchronized block that does nothing
            synchronized (lock) {
                // no-op
            }
            synchronized (lock) {
                List<String> snapshot;
                snapshot = new ArrayList<>(data);
                return snapshot;
            }
        }
    }
    
    @interface ThreadSafe {}
}