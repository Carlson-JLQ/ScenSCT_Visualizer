// A method call that is not printStackTrace, and any PrintWriter-on-StringWriter configuration present is not used to print the stack trace of exception E should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase6_Var2 {
    public static void main(String[] args) {
        // Variant 2: Try-with-resources for PrintWriter
        try (StringWriter sw = new StringWriter();
             PrintWriter pw = new PrintWriter(sw)) {
            pw.printf("%s%n", "Hello");
        } catch (Exception e) {
            // Not related to stack trace printing
        }
    }
}