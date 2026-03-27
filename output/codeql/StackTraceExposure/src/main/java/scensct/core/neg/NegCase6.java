// A method call that is not printStackTrace, and any PrintWriter-on-StringWriter configuration present is not used to print the stack trace of exception E should not be flagged.
package scensct.core.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase6 {
    public static void main(String[] args) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw); // Correct PrintWriter-on-StringWriter configuration.
        pw.println("Hello"); // Method call not printStackTrace, and no exception stack trace printed.
    }
}