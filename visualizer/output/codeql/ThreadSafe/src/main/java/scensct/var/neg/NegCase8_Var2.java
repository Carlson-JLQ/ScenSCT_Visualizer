// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public write access but locally monitored should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.Stack;

public class NegCase8_Var2 {
    @ThreadSafe
    static class TestClass {
        private Stack<String> stack = new Stack<>();
        
        public void push(String item) {
            synchronized (this) {
                // trivial guard that always passes
                if (item != null) {
                    stack.push(item);
                } else {
                    stack.push("default");
                }
            }
        }
        
        public String pop() {
            synchronized (this) {
                try {
                    return stack.pop();
                } finally {
                    // empty finally, just for structure
                }
            }
        }
    }
    
    @interface ThreadSafe {}
}