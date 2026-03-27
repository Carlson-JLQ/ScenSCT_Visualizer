// First dereference in basic block has ultimate definition that is always null (definite NPE) should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase6_Var2 {
    public static void main(String[] args) {
        // Variant 2: Control-flow restructuring with always-true condition
        String v = null;
        if (true) {
            // Dereference inside a block, same definite null
            System.out.println(v.length());
        }
    }
}