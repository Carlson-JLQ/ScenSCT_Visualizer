// First dereference in basic block has ultimate definition that is always null (definite NPE) should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase6_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical + temporary variable
        String data = null;
        String target = data;
        System.out.println(target.length());
    }
}