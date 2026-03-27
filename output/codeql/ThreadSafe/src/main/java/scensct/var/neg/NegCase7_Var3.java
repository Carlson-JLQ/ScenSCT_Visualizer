// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public accesses but locally monitored should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase7_Var3 {
    @ThreadSafe
    static class TestClass {
        private ArrayList<Integer> list = new ArrayList<>();
        
        public void addAndLog(int value) {
            // Introduce a temporary variable for the monitor
            Object lock = this;
            synchronized (lock) {
                list.add(value);
                int lastIndex = list.size() - 1; // Temporary for index
                System.out.println("Added: " + list.get(lastIndex));
            }
        }
    }
    
    @interface ThreadSafe {}
}