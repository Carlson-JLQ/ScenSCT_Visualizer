// A class annotated @ThreadSafe contains a non-thread-safe field with public write access but no problematic access patterns should not be flagged as improperly synchronized.
package scensct.core.neg;

import java.util.TreeSet;

public class NegCase9 {
    @ThreadSafe
    static class TestClass {
        private final TreeSet<Integer> set = new TreeSet<>(); // Non-thread-safe field
        private final Object lock = new Object();
        
        // Public write access properly locked with single lock
        public void add(int value) {
            synchronized (lock) {
                set.add(value);
            }
        }
        
        // Another public write access with same lock
        public void remove(int value) {
            synchronized (lock) {
                set.remove(value);
            }
        }
    }
    
    @interface ThreadSafe {}
}