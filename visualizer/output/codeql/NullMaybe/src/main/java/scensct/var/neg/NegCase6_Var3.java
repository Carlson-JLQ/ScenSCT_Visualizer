// First dereference in basic block has ultimate definition that is always null (definite NPE) should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase6_Var3 {
    public static void main(String[] args) {
        // Variant 3: Inter-procedural extraction
        String v = null;
        dereference(v);
    }
    
    private static void dereference(String s) {
        // s is definitely null when called from main
        System.out.println(s.length());
    }
}