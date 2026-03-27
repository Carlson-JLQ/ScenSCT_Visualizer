// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public accesses but locally monitored should not be flagged as improperly synchronized.
package scensct.core.neg;

import java.util.ArrayList;

public class NegCase7 {
    @ThreadSafe
    static class TestClass {
        private ArrayList<Integer> list = new ArrayList<>(); // Non-thread-safe field
        
        // Unlocked public write and read but locally monitored
        public void addAndLog(int value) {
            synchronized (this) {
                list.add(value);
                System.out.println("Added: " + list.get(list.size() - 1)); // Read within same synchronized block
            }
        }
    }
    
    @interface ThreadSafe {}
}