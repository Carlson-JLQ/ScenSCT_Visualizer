// A recognized format method call with specifier count <= argument count should not be flagged.
package scensct.var.neg;

public class NegCase9_Var4 {
    public static void main(String[] args) {
        // Variant 4: Idiomatic - use a Locale with format (still one specifier, one argument)
        String result = String.format(java.util.Locale.US, "Hello %s", "world");
    }
}