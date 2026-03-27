// A printStackTrace call whose arguments do not flow to a servlet writer sink, and any PrintWriter-on-StringWriter configuration where an exception's stack trace is printed to it does not involve converting the StringWriter to a string should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase9_Var3 {
    // Variant 3: Use try-with-resources for PrintWriter, and a different exception type.
    public static void main(String[] args) {
        Throwable t = new IllegalStateException("failure");
        try (StringWriter sw = new StringWriter();
             PrintWriter pw = new PrintWriter(sw)) {
            t.printStackTrace(pw);
            // Flush is automatic on close, but we call it explicitly for clarity.
            pw.flush();
        } catch (Exception e) {
            // Ignore, just for structure.
        }
        // The StringWriter sw is out of scope, never converted.
        t.printStackTrace();
    }
}