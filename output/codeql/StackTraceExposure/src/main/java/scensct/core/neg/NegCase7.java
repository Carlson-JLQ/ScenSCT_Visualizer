// No method call MC, and any PrintWriter-on-StringWriter configuration present is not used to print the stack trace of exception E should not be flagged.
package scensct.core.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase7 {
    public static void main(String[] args) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw); // Configuration present.
        // No method call MC, and no exception stack trace printed to pw.
    }
}