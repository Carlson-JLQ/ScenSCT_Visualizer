// A printStackTrace call whose arguments do not flow to a servlet writer sink, and any PrintWriter-on-StringWriter configuration where an exception's stack trace is printed to it does not involve converting the StringWriter to a string should not be flagged.
package scensct.core.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase9 {
    public static void main(String[] args) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        Exception e = new RuntimeException("test");
        e.printStackTrace(pw); // Stack trace printed to PrintWriter-on-StringWriter.
        pw.flush();
        // No conversion of StringWriter to string.
        e.printStackTrace(); // printStackTrace call with no arguments, not flowing to servlet writer.
    }
}