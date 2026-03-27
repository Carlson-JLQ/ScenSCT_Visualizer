// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public read access but no public write access should not be flagged as improperly synchronized.
package scensct.core.neg;

import java.util.Vector;

public class NegCase6 {
    @ThreadSafe
    static class TestClass {
        private Vector<String> vector = new Vector<>(); // Non-thread-safe field (Vector is thread-safe but treated as non-thread-safe for this scenario)
        
        // Unlocked public read access
        public int size() {
            return vector.size();
        }
        
        // No public write methods exist
        private void addPrivate(String item) {
            vector.add(item);
        }
    }
    
    @interface ThreadSafe {}
}