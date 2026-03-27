// A recognized format method call with indeterminate format string should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase6_Var3 {
    // Variant 3: Use PrintWriter.format (same rule should apply)
    public static void main(String[] args) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        String format = args.length > 0 ? args[0] : "Hello %s";
        pw.format(format, "world");
        pw.close();
    }
}