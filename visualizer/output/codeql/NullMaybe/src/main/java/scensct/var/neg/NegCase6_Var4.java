// First dereference in basic block has ultimate definition that is always null (definite NPE) should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase6_Var4 {
    public static void main(String[] args) {
        // Variant 4: Try-catch wrapper (does not change nullness)
        String v = null;
        try {
            System.out.println(v.length());
        } catch (Exception e) {
            throw e;
        }
    }
}