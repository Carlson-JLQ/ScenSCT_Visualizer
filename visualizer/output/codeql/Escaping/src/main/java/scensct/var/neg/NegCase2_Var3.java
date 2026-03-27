// A class annotated with @ThreadSafe declares a field that is final, private, or volatile should not be flagged as thread-safe concurrency issue.
package scensct.var.neg;

import com.exp.ThreadSafe;

@ThreadSafe
public class NegCase2_Var3 {
    private int privateField;
    final int finalField;
    volatile int volatileField;

    public NegCase2_Var3() {
        finalField = computeFinal();
        initVolatile();
    }

    private int computeFinal() {
        return 100;
    }

    private void initVolatile() {
        volatileField = 200;
    }
}