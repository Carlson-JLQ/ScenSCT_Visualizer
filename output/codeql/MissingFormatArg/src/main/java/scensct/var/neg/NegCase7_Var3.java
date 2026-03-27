// A recognized format method call with format string having undetermined max specifier index should not be flagged.
package scensct.var.neg;

public class NegCase7_Var3 {
    // Variant 3: Inter-procedural refactoring - extract format call to a helper
    private static String doFormat(String template, Object param) {
        return String.format(template, param);
    }

    public static void main(String[] args) {
        String result = doFormat("Hello %", "world");
    }
}