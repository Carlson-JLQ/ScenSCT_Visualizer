// A class annotated with @ThreadSafe contains a field that is inherited from a superclass or accessed from another class, not declared directly in the annotated class should not be flagged as thread-safe concurrency issue.
package scensct.var.neg;

import com.exp.ThreadSafe;

// Two-level inheritance
class GrandParent {
    int grandField;
}

class MiddleClass extends GrandParent {
    // No annotation
}

@ThreadSafe
public class NegCase3_Var4 extends MiddleClass {
    // Field is inherited through two levels, not declared here
    void method() {
        int value = grandField; // Still inherited from non-@ThreadSafe ancestor
    }
}