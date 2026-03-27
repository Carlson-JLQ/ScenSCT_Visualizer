// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public read access but no public write access should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.Vector;

public class NegCase6_Var4 {
    @ThreadSafe
    static class TestClass {
        private Vector<String> vector = new Vector<>();
        
        // Public read via a switch with one case
        public int size() {
            switch (vector.hashCode() % 1) {
                case 0: return vector.size();
                default: return -1;
            }
        }
        
        // Private write with a conditional that always executes
        private void addPrivate(String item) {
            boolean flag = true;
            if (flag) {
                vector.add(item);
            }
        }
    }
    
    @interface ThreadSafe {}
}