// Null guard in same basic block makes V non-null on path to dereference should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase5_Var1 {
    public static void main(String[] args) {
        String value = null;
        if (value == null) {
            value = "safe";
        }
        System.out.println(value.length());
    }
}