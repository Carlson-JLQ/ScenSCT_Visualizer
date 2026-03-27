// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public write access but locally monitored should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.Stack;

public class NegCase8_Var1 {
    @ThreadSafe
    static class TestClass {
        private Stack<String> dataStore = new Stack<>(); // renamed
        
        // synchronized method instead of block
        public synchronized void addElement(String elem) {
            dataStore.push(elem);
        }
        
        // keep block but with temp variable
        public String removeElement() {
            synchronized (this) {
                String result = dataStore.pop();
                return result;
            }
        }
    }
    
    @interface ThreadSafe {}
}