// A method call that is not printStackTrace, and any PrintWriter-on-StringWriter configuration present is not used to print the stack trace of exception E should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase6_Var5 {
    // Variant 5: Multiple unrelated exceptions caught, but no stack trace printed
    public static void main(String[] args) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            pw.println("Hello");
        } catch (RuntimeException e) {
            // Caught but not printed
        } catch (Exception e) {
            // Also caught but not printed
        }
    }
}