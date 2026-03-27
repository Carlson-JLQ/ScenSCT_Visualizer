// A recognized format method call with indeterminate format string should not be flagged.
package scensct.var.neg;

import java.util.Formatter;

public class NegCase6_Var1 {
    // Variant 1: Format string from a separate method, still runtime-dependent
    private static String getFormat(String[] args) {
        return args.length == 0 ? "Hello %s" : args[0];
    }

    public static void main(String[] args) {
        String fmt = getFormat(args);
        String result = String.format(fmt, "world");
    }
}