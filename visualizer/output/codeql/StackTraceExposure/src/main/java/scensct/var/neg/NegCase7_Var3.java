// No method call MC, and any PrintWriter-on-StringWriter configuration present is not used to print the stack trace of exception E should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase7_Var3 {
    // Variant 3: Inter-procedural refactoring - extract writer creation.
    private static PrintWriter createPrintWriter() {
        StringWriter sw = new StringWriter();
        return new PrintWriter(sw);
    }

    public static void main(String[] args) {
        PrintWriter pw = createPrintWriter();
        // No stack trace printed to pw.
    }
}