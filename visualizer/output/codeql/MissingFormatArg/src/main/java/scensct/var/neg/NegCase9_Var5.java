// A recognized format method call with specifier count <= argument count should not be flagged.
package scensct.var.neg;

public class NegCase9_Var5 {
    public static void main(String[] args) {
        // Variant 5: Intra-procedural - restructure control flow with an if-else that always takes the same path
        boolean flag = true;
        String result;
        if (flag) {
            result = String.format("Hello %s", "world");
        } else {
            result = "";
        }
    }
}