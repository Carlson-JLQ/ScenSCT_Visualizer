// First dereference in basic block has ultimate definition that is always null (definite NPE) should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase6_Var5 {
    public static void main(String[] args) {
        // Variant 5: Ternary operator that still yields null
        String v = args.length > 1000 ? "not null" : null;
        // args.length > 1000 is false at runtime, so v is null
        System.out.println(v.length()); // [REPORTED LINE]
    }
}