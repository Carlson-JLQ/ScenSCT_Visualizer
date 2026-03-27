// A recognized format method call with format string having undetermined max specifier index should not be flagged.
package scensct.var.neg;

public class NegCase7_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - split format string, keep malformed specifier
        String fmt = "Hello " + "%";
        String result = String.format(fmt, "world");
    }
}