// Calling a method whose name is not "getMessage" should not be flagged as sensitive data exposure.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase1_Var4 {
    public void handleError(Throwable t, PrintWriter out) {
        // Variant 4: Chain a method call (getCause) and use toString
        String msg = t.getCause().toString();
        out.write(msg);
    }
}