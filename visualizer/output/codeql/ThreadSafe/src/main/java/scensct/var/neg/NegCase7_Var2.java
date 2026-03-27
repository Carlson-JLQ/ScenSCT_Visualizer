// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public accesses but locally monitored should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase7_Var2 {
    @ThreadSafe
    static class TestClass {
        private ArrayList<Integer> list = new ArrayList<>();
        
        public void addAndLog(int value) {
            // Split synchronized block into two, but same monitor and no intervening unsynchronized access
            synchronized (this) {
                list.add(value);
            }
            // Still protected because read occurs in a separate synchronized block
            synchronized (this) {
                System.out.println("Added: " + list.get(list.size() - 1));
            }
        }
    }
    
    @interface ThreadSafe {}
}