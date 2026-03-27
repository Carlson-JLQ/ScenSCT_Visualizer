// A class annotated @ThreadSafe contains a non-thread-safe field with no public write access should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.HashSet;
import java.util.Set;

public class NegCase4_Var4 {
    @ThreadSafe
    static class TestClass {
        private final Set<String> internalSet = new HashSet<>();
        private final Object readLock = new Object();
        private final Object writeLock = new Object();
        
        private static class InternalWriter {
            static void addTo(TestClass target, String item) {
                synchronized (target.writeLock) {
                    target.internalSet.add(item);
                }
            }
        }
        
        private void addInternal(String item) {
            InternalWriter.addTo(this, item);
        }
        
        public boolean contains(String item) {
            synchronized (readLock) {
                return internalSet.contains(item);
            }
        }
    }
    
    @interface ThreadSafe {}
}