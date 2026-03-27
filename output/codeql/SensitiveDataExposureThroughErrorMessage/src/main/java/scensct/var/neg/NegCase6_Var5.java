// Throwable.getMessage() result flows to a non-HTTP response sink should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase6_Var5 {
    // Variant 5: Loop and string manipulation, still non-HTTP sink
    public void handleError(Throwable t) {
        String msg = t.getMessage();
        StringBuilder sb = new StringBuilder();
        for (char c : msg.toCharArray()) {
            sb.append(c);
        }
        System.err.println(sb.toString());
    }
}