// A class annotated @ThreadSafe contains a non-thread-safe field with public write access but no problematic access patterns should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.TreeSet;

public class NegCase9_Var2 {
    @ThreadSafe
    static class TestClass {
        private final TreeSet<Integer> set = new TreeSet<>(); // [REPORTED LINE]
        private final Object monitor = new Object();
        
        public void add(int value) {
            Object lock = monitor;
            synchronized (lock) {
                set.add(Integer.valueOf(value));
            }
        }
        
        public void remove(int value) {
            synchronized (monitor) {
                boolean removed = set.remove(value);
                if (removed) {
                    // Some dummy side effect
                    System.gc();
                }
            }
        }
        
        // Private read access (still synchronized) - doesn't affect public write pattern
        private boolean contains(int value) {
            synchronized (monitor) {
                return set.contains(value);
            }
        }
    }
    
    @interface ThreadSafe {}
}