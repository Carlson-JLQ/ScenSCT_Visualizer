// A class annotated @ThreadSafe contains a non-thread-safe field with unlocked public write access but locally monitored should not be flagged as improperly synchronized.
package scensct.var.neg;

import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

public class NegCase8_Var4 {
    @ThreadSafe
    static class TestClass {
        private final ReentrantLock lock = new ReentrantLock();
        private Stack<String> stack = new Stack<>();
        
        public void push(String item) {
            lock.lock();
            try {
                stack.push(item);
            } finally {
                lock.unlock();
            }
        }
        
        public String pop() {
            lock.lock();
            try {
                return stack.pop();
            } finally {
                lock.unlock();
            }
        }
    }
    
    @interface ThreadSafe {}
}