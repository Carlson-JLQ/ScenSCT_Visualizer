// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public write access but locally monitored should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.Stack;

public class NegCase8_Var3 {
    @ThreadSafe
    static class TestClass {
        private Stack<String> stack = new Stack<>();
        
        private void internalPush(String val) {
            stack.push(val);
        }
        
        private String internalPop() {
            return stack.pop();
        }
        
        public void push(String item) {
            synchronized (this) {
                internalPush(item);
            }
        }
        
        public String pop() {
            synchronized (this) {
                return internalPop();
            }
        }
    }
    
    @interface ThreadSafe {}
}