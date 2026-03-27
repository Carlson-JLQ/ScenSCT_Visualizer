// A class annotated @ThreadSafe contains a non-thread-safe field with no public write access should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.HashSet;
import java.util.Set;

public class NegCase4_Var2 {
    @ThreadSafe
    static class TestClass {
        private final Set<String> internalSet;
        private final Object readMonitor = new Object();
        private final Object writeMonitor = new Object();
        
        private TestClass() {
            internalSet = new HashSet<>();
        }
        
        static TestClass createWithInitial(String initialItem) {
            TestClass instance = new TestClass();
            synchronized (instance.writeMonitor) {
                instance.internalSet.add(initialItem);
            }
            return instance;
        }
        
        private void addInternal(String item) {
            synchronized (writeMonitor) {
                internalSet.add(item);
            }
        }
        
        public boolean contains(String item) {
            synchronized (readMonitor) {
                return internalSet.contains(item);
            }
        }
    }
    
    @interface ThreadSafe {}
}