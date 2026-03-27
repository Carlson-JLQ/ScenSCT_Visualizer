// A class annotated with @ThreadSafe declares a field that is final, private, or volatile should not be flagged as thread-safe concurrency issue.
package scensct.var.neg;

import com.exp.ThreadSafe;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
public class NegCase2_Var4 {
    private final int privateField;
    final int finalField = 0;
    // AtomicInteger as a thread-safe alternative to volatile int
    private final AtomicInteger safeCounter = new AtomicInteger(0);

    public NegCase2_Var4(int val) {
        privateField = val;
    }
}