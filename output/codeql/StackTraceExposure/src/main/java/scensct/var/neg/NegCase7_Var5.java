// No method call MC, and any PrintWriter-on-StringWriter configuration present is not used to print the stack trace of exception E should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase7_Var5 {
    public static void main(String[] args) {
        // Variant 5: Splitting the PrintWriter initialization across multiple steps.
        StringWriter sw = new StringWriter();
        PrintWriter pw;
        pw = new PrintWriter(sw);
        // No operation that prints a stack trace.
    }
}