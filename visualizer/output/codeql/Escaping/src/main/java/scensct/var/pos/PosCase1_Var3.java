// A class annotated with @ThreadSafe contains a non-final, non-private, non-volatile instance field should be flagged as a concurrency issue.
package scensct.var.pos;

@interface ThreadSafe {}

@ThreadSafe
public class PosCase1_Var3 {
    // Field declared with an annotation (e.g., SuppressWarnings) that does not affect thread-safety
    @SuppressWarnings("unused")
    Object sharedData; // [REPORTED LINE]
    
    // Constructor that initializes the field
    public PosCase1_Var3() {
        sharedData = new Object();
    }
}