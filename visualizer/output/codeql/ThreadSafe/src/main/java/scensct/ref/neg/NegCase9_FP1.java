// A class annotated @ThreadSafe contains a non-thread-safe field with public write access but no problematic access patterns should not be flagged as improperly synchronized.
package scensct.ref.neg;

import java.util.TreeSet;

public class NegCase9_FP1 {
    @ThreadSafe
    static class TestClass {
        private final TreeSet<Integer> set = new TreeSet<>(); // Non-thread-safe field // [REPORTED LINE]
        private final Object lock1 = new Object();
        private final Object lock2 = new Object();
        
        // Public write access but properly locked
        public void add(int value) {
            synchronized (lock1) {
                set.add(value);
            }
        }
        
        // Another public write access with different lock
        public void remove(int value) {
            synchronized (lock2) {
                set.remove(value);
            }
        }
        
        // No unlocked public write access exists
    }
    
    @interface ThreadSafe {}
}