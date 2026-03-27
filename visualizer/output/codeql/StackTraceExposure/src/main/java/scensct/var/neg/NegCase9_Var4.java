// A printStackTrace call whose arguments do not flow to a servlet writer sink, and any PrintWriter-on-StringWriter configuration where an exception's stack trace is printed to it does not involve converting the StringWriter to a string should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase9_Var4 {
    // Variant 4: Split into two separate methods, one for each printStackTrace call.
    private static void printToLocalStringWriter(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        pw.flush();
        // sw never converted to string.
    }

    private static void printToStdErr(Exception e) {
        e.printStackTrace();
    }

    public static void main(String[] args) {
        Exception e = new RuntimeException("demo");
        printToLocalStringWriter(e);
        printToStdErr(e);
    }
}