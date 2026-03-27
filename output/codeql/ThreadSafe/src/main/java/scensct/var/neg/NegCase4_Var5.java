// A class annotated @ThreadSafe contains a non-thread-safe field with no public write access should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NegCase4_Var5 {
    @ThreadSafe
    static class TestClass {
        private final Set<String> internalSet = Collections.synchronizedSet(new HashSet<>());
        private final Object writeLock = new Object();
        
        private void addInternal(String item) {
            // Even though internalSet is synchronized, we add extra synchronization
            // to demonstrate multiple locks, but writes remain private.
            synchronized (writeLock) {
                internalSet.add(item);
            }
        }
        
        public synchronized boolean contains(String item) {
            return internalSet.contains(item);
        }
    }
    
    @interface ThreadSafe {}
}