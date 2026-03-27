// Null guard in same basic block makes V non-null on path to dereference should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase5_Var5 {
    public static void main(String[] args) {
        String v = null;
        switch (args.length) {
            case 0:
                if (v == null) {
                    v = "assigned";
                }
                break;
            default:
                // unreachable for this test
                v = null;
        }
        // v is non-null here because args.length is 0 in normal execution
        System.out.println(v.length()); // [REPORTED LINE]
    }
}