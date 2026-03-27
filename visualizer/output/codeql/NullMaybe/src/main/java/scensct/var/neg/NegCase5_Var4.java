// Null guard in same basic block makes V non-null on path to dereference should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase5_Var4 {
    private static String ensureNonNull(String input) {
        if (input == null) {
            return "default";
        }
        return input;
    }
    
    public static void main(String[] args) {
        String v = null;
        v = ensureNonNull(v);
        System.out.println(v.length());
    }
}