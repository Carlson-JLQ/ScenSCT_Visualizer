// A method call that is not printStackTrace, and any PrintWriter-on-StringWriter configuration present is not used to print the stack trace of exception E should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase6_Var4 {
    // Variant 4: Control flow with conditional that always prints
    public static void main(String[] args) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        boolean flag = true;
        if (flag) {
            pw.print("H");
            pw.print("ello");
            pw.println();
        } else {
            // Dead code, never prints stack trace
        }
    }
}