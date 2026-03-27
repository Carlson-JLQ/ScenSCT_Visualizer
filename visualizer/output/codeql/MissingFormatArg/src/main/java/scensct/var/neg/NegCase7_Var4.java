// A recognized format method call with format string having undetermined max specifier index should not be flagged.
package scensct.var.neg;

public class NegCase7_Var4 {
    public static void main(String[] args) {
        // Variant 4: Idiomatic variation - use Formatter class directly, same malformed specifier
        java.util.Formatter f = new java.util.Formatter();
        f.format("Hello %", "world");
        String result = f.toString();
    }
}