// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public reads via non-public methods but no problematic write access should not be flagged as improperly synchronized.
package scensct.core.neg;

import java.util.PriorityQueue;

public class NegCase10 {
    @ThreadSafe
    static class TestClass {
        private final PriorityQueue<Double> queue = new PriorityQueue<>(); // Non-thread-safe field // [REPORTED LINE]
        private final Object lock = new Object();
        
        // Public read access synchronized
        public synchronized Double peekMin() {
            return queue.peek();
        }
        
        // Write access is properly locked
        public void insert(double value) {
            synchronized (lock) {
                queue.add(value);
            }
        }
    }
    
    @interface ThreadSafe {}
}