// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public accesses but locally monitored should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase7_Var4 {
    @ThreadSafe
    static class TestClass {
        private ArrayList<Integer> list = new ArrayList<>();
        
        // Extract synchronized block logic into a private helper method
        public void addAndLog(int value) {
            addValueSafely(value);
        }
        
        private synchronized void addValueSafely(int val) {
            list.add(val);
            System.out.println("Added: " + list.get(list.size() - 1));
        }
    }
    
    @interface ThreadSafe {}
}