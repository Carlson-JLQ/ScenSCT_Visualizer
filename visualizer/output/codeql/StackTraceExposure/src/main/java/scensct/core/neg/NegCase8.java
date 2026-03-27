// A method call that is not printStackTrace, and there exists a PrintWriter-on-StringWriter configuration where an exception's stack trace is printed to it, but the StringWriter is not converted to a string via toString() should not be flagged.
package scensct.core.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase8 {
    public static void main(String[] args) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        Exception e = new RuntimeException("test");
        e.printStackTrace(pw); // Stack trace printed to PrintWriter-on-StringWriter.
        pw.flush();
        // StringWriter not converted to string via toString().
        System.out.println("Done"); // Method call not printStackTrace.
    }
}