// First dereference in basic block has ultimate definition that is always null (definite NPE) should not be flagged as potential null pointer dereference.
package scensct.core.neg;

public class NegCase6 {
    public static void main(String[] args) {
        String v = null; // Source: V is definitely null
        // Ultimate definition is null, dereference is unreachable or definite NPE
        System.out.println(v.length()); // Dereference: V is definitely null, checker may suppress
    }
}