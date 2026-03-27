// A printStackTrace call whose arguments do not flow to a servlet writer sink, and any PrintWriter-on-StringWriter configuration where an exception's stack trace is printed to it does not involve converting the StringWriter to a string should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase9_Var5 {
    // Variant 5: Introduce a conditional that doesn't affect the flow, and use a loop.
    public static void main(String[] args) {
        StringWriter sw = null;
        PrintWriter pw = null;
        for (int i = 0; i < 1; i++) { // loop runs once, just to add complexity
            sw = new StringWriter();
            pw = new PrintWriter(sw);
        }
        Exception e = new RuntimeException("test");
        if (pw != null) {
            e.printStackTrace(pw);
            pw.flush();
        }
        // sw still not converted.
        e.printStackTrace();
    }
}