// A recognized format method call with indeterminate format string should not be flagged.
package scensct.var.neg;

public class NegCase6_Var2 {
    // Variant 2: Format string built via StringBuilder, still indeterminate
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(args.length > 0 ? args[0] : "Hello ");
        sb.append("%s");
        String format = sb.toString();
        String result = String.format(format, "world");
    }
}