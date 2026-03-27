// A class annotated with @ThreadSafe contains a non-final, non-private, non-volatile instance field should be flagged as a concurrency issue.
package scensct.var.pos;

@interface ThreadSafe {}

@ThreadSafe
public class PosCase1_Var1 {
    // Renamed field, changed type, reordered modifiers (default package-private remains)
    long mutableState; // [REPORTED LINE]
}