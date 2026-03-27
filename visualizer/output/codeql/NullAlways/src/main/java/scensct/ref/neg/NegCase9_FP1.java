// Dereference exists but not in the specific basic block under analysis should not be flagged as always null.
package scensct.ref.neg;

public class NegCase9_FP1 {
    public static void main(String[] args) {
        Object local = null;
        if (args.length > 0) {
            // Then block - no dereference here
        } else {
            // Else block contains dereference, but analyzing then block
            System.out.println(local.toString()); // [REPORTED LINE]
        }
    }
}