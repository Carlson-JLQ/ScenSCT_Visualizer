// A method call that is not printStackTrace, and there exists a PrintWriter-on-StringWriter configuration where an exception's stack trace is printed to it, but the StringWriter is not converted to a string via toString() should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase8_Var1 {
    public static void main(String[] args) {
        // Variant 1: Control flow restructuring with early return
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        Exception e = new RuntimeException("test");
        if (args.length == 0) {
            e.printStackTrace(pw);
            pw.flush();
        } else {
            return;
        }
        // Still no toString() on sw
        System.out.println("Done");
    }
}