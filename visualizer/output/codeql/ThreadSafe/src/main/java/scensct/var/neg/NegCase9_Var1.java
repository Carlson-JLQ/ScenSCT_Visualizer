// A class annotated @ThreadSafe contains a non-thread-safe field with public write access but no problematic access patterns should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.TreeSet;
import java.util.concurrent.locks.ReentrantLock;

public class NegCase9_Var1 {
    @ThreadSafe
    static class TestClass {
        private final TreeSet<Integer> dataSet = new TreeSet<>();
        private final ReentrantLock dataLock = new ReentrantLock();
        
        public void add(int value) {
            dataLock.lock();
            try {
                dataSet.add(value);
            } finally {
                dataLock.unlock();
            }
        }
        
        public void remove(int value) {
            dataLock.lock();
            try {
                dataSet.remove(value);
            } finally {
                dataLock.unlock();
            }
        }
    }
    
    @interface ThreadSafe {}
}