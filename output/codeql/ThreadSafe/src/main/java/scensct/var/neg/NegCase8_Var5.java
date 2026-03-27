// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public write access but locally monitored should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.Stack;

public class NegCase8_Var5 {
    @ThreadSafe
    static class TestClass {
        private Stack<String> stack = new Stack<>();
        
        private void unsafePush(String s) {
            stack.push(s);
        }
        
        private String unsafePop() {
            return stack.pop();
        }
        
        public void push(String item) {
            synchronized (this) {
                unsafePush(item);
            }
        }
        
        public String pop() {
            synchronized (this) {
                return unsafePop();
            }
        }
        
        // private method, not part of public interface
        private int internalSize() {
            return stack.size();
        }
    }
    
    @interface ThreadSafe {}
}