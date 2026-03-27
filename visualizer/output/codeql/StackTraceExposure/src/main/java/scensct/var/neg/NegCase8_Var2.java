// A method call that is not printStackTrace, and there exists a PrintWriter-on-StringWriter configuration where an exception's stack trace is printed to it, but the StringWriter is not converted to a string via toString() should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase8_Var2 {
    public static void main(String[] args) {
        // Variant 2: Extract PrintWriter creation and stack trace printing to a helper method
        StringWriter sw = new StringWriter();
        captureStackTrace(sw);
        // No toString() on sw
        System.out.println("Done");
    }

    private static void captureStackTrace(StringWriter sw) {
        PrintWriter pw = new PrintWriter(sw);
        new RuntimeException("test").printStackTrace(pw);
        pw.flush();
    }
}