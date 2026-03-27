// Calling a method whose name is not "getMessage" should not be flagged as sensitive data exposure.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase1_Var3 {
    public void handleError(Throwable t, PrintWriter out) {
        // Variant 3: Use a temporary variable and control flow
        String msg;
        if (t != null) {
            msg = t.toString();
        } else {
            msg = "Unknown error";
        }
        out.append(msg);
    }
}