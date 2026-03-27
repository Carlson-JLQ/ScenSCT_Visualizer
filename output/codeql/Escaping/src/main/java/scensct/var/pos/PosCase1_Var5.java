// A class annotated with @ThreadSafe contains a non-final, non-private, non-volatile instance field should be flagged as a concurrency issue.
package scensct.var.pos;

@interface ThreadSafe {}

@ThreadSafe
public class PosCase1_Var5 {
    // Field with multiple non-final, non-private, non-volatile modifiers (transient is irrelevant)
    transient String buffer; // [REPORTED LINE]
    
    // Helper method that uses the field, but no synchronization
    void append(String s) {
        if (buffer == null) buffer = "";
        buffer += s;
    }
}