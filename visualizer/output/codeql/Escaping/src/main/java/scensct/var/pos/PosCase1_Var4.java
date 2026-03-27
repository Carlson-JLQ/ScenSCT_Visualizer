// A class annotated with @ThreadSafe contains a non-final, non-private, non-volatile instance field should be flagged as a concurrency issue.
package scensct.var.pos;

@interface ThreadSafe {}

@ThreadSafe
public class PosCase1_Var4 {
    // Field is protected (still not private) and non-final, non-volatile
    protected int value; // [REPORTED LINE]
    
    // A getter that is not synchronized, exposing the field
    public int getValue() {
        return value;
    }
}