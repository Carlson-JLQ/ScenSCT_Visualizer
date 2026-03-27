// Null guard in same basic block makes V non-null on path to dereference should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase5_Var3 {
    public static void main(String[] args) {
        String v = null;
        boolean isNull = (v == null);
        if (isNull) {
            v = "guarded";
        }
        // same block
        int len = v.length();
        System.out.println(len);
    }
}