// A recognized format method call with indeterminate format string should not be flagged.
package scensct.var.neg;

import java.util.Formatter;

public class NegCase6_Var5 {
    // Variant 5: Use Formatter class directly, format from a conditional block
    public static void main(String[] args) {
        String format;
        if (args.length > 0) {
            format = args[0];
        } else {
            format = "Hello %s";
        }
        Formatter formatter = new Formatter();
        formatter.format(format, "world");
        String result = formatter.toString();
        formatter.close();
    }
}