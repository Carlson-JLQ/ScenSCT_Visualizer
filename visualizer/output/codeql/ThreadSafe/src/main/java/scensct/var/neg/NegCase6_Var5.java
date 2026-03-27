// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public read access but no public write access should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.Vector;

public class NegCase6_Var5 {
    @ThreadSafe
    static class TestClass {
        private Vector<String> vector = new Vector<>();
        
        // Public read split across two lines
        public int size() {
            int result = vector.size();
            return result;
        }
        
        // No public write; private write is a no-arg method that adds a constant
        private void addPrivate() {
            vector.add("default");
        }
        
        // Overloaded private write with parameter (still private)
        private void addPrivate(String item) {
            vector.add(item);
        }
    }
    
    @interface ThreadSafe {}
}