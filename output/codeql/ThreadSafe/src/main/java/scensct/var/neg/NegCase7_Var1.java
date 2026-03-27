// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public accesses but locally monitored should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase7_Var1 {
    @ThreadSafe
    static class TestClass {
        private ArrayList<Integer> data = new ArrayList<>(); // Renamed field
        
        // Synchronized method instead of synchronized block
        public synchronized void addAndLog(int value) {
            data.add(value);
            System.out.println("Added: " + data.get(data.size() - 1));
        }
    }
    
    @interface ThreadSafe {}
}