// A class annotated @ThreadSafe contains a non-thread-safe field with no public write access should not be flagged as improperly synchronized.
package scensct.core.neg;

import java.util.HashSet;
import java.util.Set;

public class NegCase4 {
    @ThreadSafe
    static class TestClass {
        private final Set<String> internalSet = new HashSet<>(); // Non-thread-safe field
        private final Object readLock = new Object();
        private final Object writeLock = new Object();
        
        // No public write method exists
        private void addInternal(String item) {
            synchronized (writeLock) {
                internalSet.add(item);
            }
        }
        
        public boolean contains(String item) {
            synchronized (readLock) {
                return internalSet.contains(item);
            }
        }
    }
    
    @interface ThreadSafe {}
}