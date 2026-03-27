// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public read access but no public write access should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.Vector;

public class NegCase6_Var1 {
    @ThreadSafe
    static class TestClass {
        private Vector<String> vector = new Vector<>();
        
        // Public read via a computed expression
        public int getSize() {
            int sz = vector.size();
            return sz;
        }
        
        // Private write with a guard condition
        private void addPrivate(String item) {
            if (item != null) {
                vector.add(item);
            }
        }
    }
    
    @interface ThreadSafe {}
}