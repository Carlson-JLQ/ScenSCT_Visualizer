// A method call that is not printStackTrace, and there exists a PrintWriter-on-StringWriter configuration where an exception's stack trace is printed to it, but the StringWriter is not converted to a string via toString() should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase8_Var5 {
    public static void main(String[] args) {
        // Variant 5: Loop structure, stack trace printed inside loop, still no toString()
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                new RuntimeException("iteration " + i).printStackTrace(pw);
            }
        }
        pw.flush();
        // sw never turned to string
        System.out.println("Done");
    }
}