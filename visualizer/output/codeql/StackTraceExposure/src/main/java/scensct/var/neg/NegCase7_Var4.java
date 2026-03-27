// No method call MC, and any PrintWriter-on-StringWriter configuration present is not used to print the stack trace of exception E should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase7_Var4 {
    public static void main(String[] args) {
        // Variant 4: Try-with-resources for PrintWriter, but no exception handling.
        try (StringWriter sw = new StringWriter();
             PrintWriter pw = new PrintWriter(sw)) {
            // Inside the try block, no stack trace printing occurs.
        } catch (Exception e) {
            // Not reached.
        }
    }
}