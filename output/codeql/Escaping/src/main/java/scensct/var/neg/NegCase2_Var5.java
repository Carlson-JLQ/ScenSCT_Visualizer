// A class annotated with @ThreadSafe declares a field that is final, private, or volatile should not be flagged as thread-safe concurrency issue.
package scensct.var.neg;

import com.exp.ThreadSafe;

@ThreadSafe
public class NegCase2_Var5 {
    private int privateField;
    final int finalField;
    volatile int volatileField;

    public NegCase2_Var5() {
        try {
            finalField = 10;
        } finally {
            volatileField = 20;
        }
    }

    // Synchronized getter but field remains private
    public synchronized int getPrivateField() {
        return privateField;
    }

    public synchronized void setPrivateField(int v) {
        privateField = v;
    }
}