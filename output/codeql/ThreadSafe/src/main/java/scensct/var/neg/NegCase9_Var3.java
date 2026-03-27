// A class annotated @ThreadSafe contains a non-thread-safe field with public write access but no problematic access patterns should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.TreeSet;

public class NegCase9_Var3 {
    @ThreadSafe
    static class TestClass {
        private final TreeSet<Integer> set = new TreeSet<>();
        private final Object lock = new Object();
        
        public void add(int value) {
            acquireLockAndAdd(value);
        }
        
        private void acquireLockAndAdd(int val) {
            synchronized (lock) {
                set.add(val);
            }
        }
        
        public void remove(int value) {
            synchronized (lock) {
                performRemoval(value);
            }
        }
        
        private void performRemoval(int val) {
            set.remove(val);
        }
    }
    
    @interface ThreadSafe {}
}