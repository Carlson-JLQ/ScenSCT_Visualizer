// A printStackTrace call whose arguments do not flow to a servlet writer sink, and any PrintWriter-on-StringWriter configuration where an exception's stack trace is printed to it does not involve converting the StringWriter to a string should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase9_Var1 {
    public static void main(String[] args) {
        // Variant 1: Reorder and introduce temporaries, wrap in try-finally for flush.
        Exception ex = new RuntimeException("error");
        StringWriter buffer = new StringWriter();
        PrintWriter printer = new PrintWriter(buffer);
        try {
            ex.printStackTrace(printer);
        } finally {
            printer.flush();
        }
        // Still no conversion of buffer to string.
        ex.printStackTrace();
    }
}