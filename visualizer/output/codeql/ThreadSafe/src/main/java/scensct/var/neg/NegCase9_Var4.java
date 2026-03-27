// A class annotated @ThreadSafe contains a non-thread-safe field with public write access but no problematic access patterns should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NegCase9_Var4 {
    @ThreadSafe
    static class TestClass {
        private final NavigableSet<Integer> items;
        private final Object syncObj;
        
        TestClass() {
            this.items = new TreeSet<>();
            this.syncObj = new Object();
        }
        
        public void add(int value) {
            synchronized (syncObj) {
                items.add(value);
            }
        }
        
        public void remove(int value) {
            synchronized (syncObj) {
                items.remove(value);
            }
        }
    }
    
    @interface ThreadSafe {}
}