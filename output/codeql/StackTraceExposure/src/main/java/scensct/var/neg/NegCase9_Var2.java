// A printStackTrace call whose arguments do not flow to a servlet writer sink, and any PrintWriter-on-StringWriter configuration where an exception's stack trace is printed to it does not involve converting the StringWriter to a string should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase9_Var2 {
    // Variant 2: Extract StringWriter/PrintWriter setup to a helper method.
    private static PrintWriter createPrintWriterOnStringWriter() {
        StringWriter sw = new StringWriter();
        return new PrintWriter(sw);
    }

    public static void main(String[] args) {
        PrintWriter pw = createPrintWriterOnStringWriter();
        RuntimeException re = new RuntimeException("test");
        re.printStackTrace(pw);
        pw.flush();
        // No conversion of the underlying StringWriter to string.
        re.printStackTrace();
    }
}