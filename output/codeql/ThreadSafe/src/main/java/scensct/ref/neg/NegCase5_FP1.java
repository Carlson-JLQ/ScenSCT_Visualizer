// A class annotated @ThreadSafe contains a non-thread-safe field with public reads via non-public methods without local monitoring but no problematic write access should not be flagged as improperly synchronized.
package scensct.ref.neg;

import java.util.LinkedList;
import java.util.Queue;

public class NegCase5_FP1 {
    @ThreadSafe
    static class TestClass {
        private final Queue<String> queue = new LinkedList<>(); // Non-thread-safe field
        private final Object lock = new Object();
        
        // Public read access via non-public method without local monitoring
        public String peek() {
            return getFirst(); // Unlocked read
        }
        
        private String getFirst() {
            return queue.peek(); // No local monitoring // [REPORTED LINE]
        }
        
        // Write access is properly locked
        public void add(String item) {
            synchronized (lock) {
                queue.add(item);
            }
        }
    }
    
    @interface ThreadSafe {}
}