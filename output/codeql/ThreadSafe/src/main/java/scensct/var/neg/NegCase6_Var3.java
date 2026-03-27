// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public read access but no public write access should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.Vector;

public class NegCase6_Var3 {
    @ThreadSafe
    static class TestClass {
        private final Vector<String> vector = new Vector<>();
        
        // Public read with a temporary variable and early return
        public int size() {
            Vector<String> v = this.vector;
            return v.size();
        }
        
        // Private write inside a try-catch (no effect)
        private void addPrivate(String item) {
            try {
                vector.add(item);
            } catch (Exception e) {
                // ignore
            }
        }
    }
    
    @interface ThreadSafe {}
}