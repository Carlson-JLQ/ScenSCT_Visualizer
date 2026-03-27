// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public read access but no public write access should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.Vector;

public class NegCase6_Var2 {
    @ThreadSafe
    static class TestClass {
        private Vector<String> vector;
        
        // Constructor initializes
        TestClass() {
            vector = new Vector<>();
        }
        
        // Public read wrapped in a trivial loop
        public int size() {
            for (int i = 0; i < 1; i++) {
                return vector.size();
            }
            return 0;
        }
        
        // Private write extracted to a helper
        private void addPrivate(String item) {
            internalAdd(item);
        }
        
        private void internalAdd(String s) {
            vector.add(s);
        }
    }
    
    @interface ThreadSafe {}
}