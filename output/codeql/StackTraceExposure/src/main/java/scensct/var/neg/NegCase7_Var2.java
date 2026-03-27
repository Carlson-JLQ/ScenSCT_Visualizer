// No method call MC, and any PrintWriter-on-StringWriter configuration present is not used to print the stack trace of exception E should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase7_Var2 {
    public static void main(String[] args) {
        // Variant 2: Intra-procedural control flow with a conditional that never executes.
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        if (false) {
            // Dead code block; no actual stack trace printing.
            Exception e = new Exception();
            e.printStackTrace(); // This is not printed to pw, so still safe.
        }
        // No method call MC.
    }
}