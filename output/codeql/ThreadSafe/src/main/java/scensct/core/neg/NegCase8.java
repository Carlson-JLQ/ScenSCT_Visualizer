// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public write access but locally monitored should not be flagged as improperly synchronized.
package scensct.core.neg;

import java.util.Stack;

public class NegCase8 {
    @ThreadSafe
    static class TestClass {
        private Stack<String> stack = new Stack<>(); // Non-thread-safe field
        
        // Unlocked public write access but locally monitored
        public void push(String item) {
            synchronized (this) {
                stack.push(item);
            }
        }
        
        // Public read access is locked
        public String pop() {
            synchronized (this) {
                return stack.pop();
            }
        }
    }
    
    @interface ThreadSafe {}
}