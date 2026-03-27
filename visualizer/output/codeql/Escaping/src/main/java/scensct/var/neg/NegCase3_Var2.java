// A class annotated with @ThreadSafe contains a field that is inherited from a superclass or accessed from another class, not declared directly in the annotated class should not be flagged as thread-safe concurrency issue.
package scensct.var.neg;

import com.exp.ThreadSafe;

// Superclass with package-private field
class Parent {
    int parentField; // Non-final, non-private, non-volatile
}

@ThreadSafe
public class NegCase3_Var2 extends Parent {
    // Access through a helper method that does not change synchronization
    private int getFieldValue() {
        return parentField;
    }
    
    void method() {
        int value = getFieldValue(); // Indirect access
    }
}