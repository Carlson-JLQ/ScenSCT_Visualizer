// A class annotated with @ThreadSafe declares a field that is final, private, or volatile should not be flagged as thread-safe concurrency issue.
package scensct.var.neg;

import com.exp.ThreadSafe;

@ThreadSafe
public class NegCase2_Var1 {
    // Reorder and add harmless static to one field
    static private int privateField;
    final int finalField;
    volatile int volatileField;

    // Constructor to initialize final field
    public NegCase2_Var1() {
        finalField = 0;
    }
}