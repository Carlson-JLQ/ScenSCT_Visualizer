// A recognized format method call with specifier count <= argument count should not be flagged.
package scensct.var.neg;

public class NegCase9_Var2 {
    public static void main(String[] args) {
        // Variant 2: Intra-procedural - wrap in try-catch and use a local variable for argument
        try {
            String msg = String.format("Hello %s", "world");
        } catch (Exception e) {
            // ignore
        }
    }
}