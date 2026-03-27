// Dereference exists but not in the specific basic block under analysis should not be flagged as always null.
package scensct.core.neg;

public class NegCase9 {
    public static void main(String[] args) {
        Object local = null;
        if (args.length > 0) {
            // Then block - no dereference here
        } else {
            // Else block contains dereference, but analyzing then block
            // Make local conditionally non-null to evade always-null detection
            if (args.length < 0) {
                local = new Object();
            }
            System.out.println(local.toString()); // [REPORTED LINE]
        }
    }
}