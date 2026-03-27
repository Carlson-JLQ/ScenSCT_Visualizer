// A class without the @ThreadSafe annotation contains a non-final, non-private, non-volatile field should not be flagged as thread-safe concurrency issue.
package scensct.var.neg;

public class NegCase1_Var5 {
    // Original field renamed and made part of a volatile-like name but not actually volatile
    int sharedCounter;

    // A synchronized method on a different lock object does not make the class thread-safe annotated
    public synchronized void increment() {
        sharedCounter++;
    }

    // Note: The class still lacks @ThreadSafe annotation.
    // The presence of a synchronized method does not change the scenario for this checker,
    // as the rule is based on annotation, not on synchronization presence.
}