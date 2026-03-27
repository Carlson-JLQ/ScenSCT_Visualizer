// A class annotated @ThreadSafe contains a non-thread-safe field with public write access but no problematic access patterns should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.TreeSet;

public class NegCase9_Var5 {
    @ThreadSafe
    static class TestClass {
        private final TreeSet<Integer> set = new TreeSet<>(); // [REPORTED LINE]
        private final Object lock = new Object();
        
        public void add(int value) {
            synchronized (lock) {
                TreeSet<Integer> localRef = set;
                localRef.add(value);
            }
        }
        
        public void remove(int value) {
            Object guard = lock;
            synchronized (guard) {
                if (value >= 0) {
                    set.remove(value);
                } else {
                    set.remove(Math.abs(value));
                }
            }
        }
        
        // Package-private access with same lock (still synchronized)
        void clearAll() {
            synchronized (lock) {
                set.clear();
            }
        }
    }
    
    @interface ThreadSafe {}
}