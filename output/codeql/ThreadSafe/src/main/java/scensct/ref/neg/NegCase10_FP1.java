// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public reads via non-public methods but no problematic write access should not be flagged as improperly synchronized.
package scensct.ref.neg;

import java.util.PriorityQueue;

public class NegCase10_FP1 {
    @ThreadSafe
    static class TestClass {
        private final PriorityQueue<Double> queue = new PriorityQueue<>(); // Non-thread-safe field
        private final Object lock = new Object();
        
        // Unlocked public read access via non-public method
        public Double peekMin() {
            return getMin(); // Unlocked read
        }
        
        private Double getMin() {
            return queue.peek(); // No local monitoring // [REPORTED LINE]
        }
        
        // Write access is properly locked (not unlocked)
        public void insert(double value) {
            synchronized (lock) {
                queue.add(value);
            }
        }
    }
    
    @interface ThreadSafe {}
}