// A class annotated @ThreadSafe contains a non-thread-safe field with all accesses protected by the same lock should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.List;

public class NegCase2_Var3 {
    @ThreadSafe
    static class TestClass {
        private final Object primaryLock = new Object();
        private List<String> data; // [REPORTED LINE]
        
        TestClass() {
            synchronized (primaryLock) {
                data = new ArrayList<>();
            }
        }
        
        public void add(String item) {
            Object lockRef = primaryLock; // alias
            synchronized (lockRef) {
                data.add(item);
            }
        }
        
        public List<String> getAll() {
            synchronized (primaryLock) {
                return new ArrayList<>(data);
            }
        }
    }
    
    @interface ThreadSafe {}
}