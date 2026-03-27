// A class annotated @ThreadSafe contains a non-thread-safe field with all accesses protected by the same lock should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.List;

public class NegCase2_Var4 {
    @ThreadSafe
    static class TestClass {
        private final Object lock = this; // final reference to this
        private List<String> data = new ArrayList<>();
        
        public void add(String item) {
            synchronized (lock) {
                data.add(item);
            }
        }
        
        public List<String> getAll() {
            synchronized (lock) {
                return new ArrayList<>(data);
            }
        }
    }
    
    @interface ThreadSafe {}
}