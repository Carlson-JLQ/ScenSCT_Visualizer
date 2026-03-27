// No method call MC, and any PrintWriter-on-StringWriter configuration present does not have the correct relationship should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.OutputStream;

public class NegCase4_Var3 {
    // Variant 3: Aliasing and try-with-resources (no catch for exception)
    public static void main(String[] args) {
        OutputStream os = System.out;
        try (PrintWriter pw = new PrintWriter(os)) {
            StringWriter sw = new StringWriter();
            // sw is unrelated to pw.
            // No method call MC inside try block.
        }
        // Still safe.
    }
}