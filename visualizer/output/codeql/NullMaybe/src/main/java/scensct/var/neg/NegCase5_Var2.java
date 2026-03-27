// Null guard in same basic block makes V non-null on path to dereference should not be flagged as potential null pointer dereference.
package scensct.var.neg;

import java.util.Objects;

public class NegCase5_Var2 {
    public static void main(String[] args) {
        String v = null;
        v = (v == null) ? Objects.requireNonNull("non-null") : v;
        System.out.println(v.length());
    }
}