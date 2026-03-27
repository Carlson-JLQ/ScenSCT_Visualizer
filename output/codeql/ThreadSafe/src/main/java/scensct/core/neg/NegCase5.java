// A class annotated @ThreadSafe contains a non-thread-safe field with public reads via non-public methods without local monitoring but no problematic write access should not be flagged as improperly synchronized.
package scensct.core.neg;

import java.util.LinkedList;
import java.util.Queue;

public class NegCase5 {
    @ThreadSafe
    static class TestClass {
        private final Queue<String> queue = new LinkedList<>(); // Non-thread-safe field // [REPORTED LINE]
        private final Object lock = new Object();
        
        // Public read access synchronized
        public synchronized String peek() {
            return queue.peek();
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