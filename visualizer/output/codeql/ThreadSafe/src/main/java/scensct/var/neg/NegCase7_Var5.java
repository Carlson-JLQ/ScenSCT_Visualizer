// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public accesses but locally monitored should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.Vector; // Changed to a thread-safe collection, but field type is still non-thread-safe List

public class NegCase7_Var5 {
    @ThreadSafe
    static class TestClass {
        private java.util.List<Integer> list = new java.util.ArrayList<>(); // Non-thread-safe reference
        
        public void addAndLog(int value) {
            synchronized (this) {
                list.add(value);
                System.out.println("Added: " + list.get(list.size() - 1));
            }
        }
    }
    
    @interface ThreadSafe {}
}