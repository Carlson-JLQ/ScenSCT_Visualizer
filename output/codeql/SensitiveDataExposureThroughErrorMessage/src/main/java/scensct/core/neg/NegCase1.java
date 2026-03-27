// Calling a method whose name is not "getMessage" should not be flagged as sensitive data exposure.
package scensct.core.neg;

import java.io.PrintWriter;

public class NegCase1 {
    public void handleError(Throwable t, PrintWriter out) {
        // Scenario 1: method name is "toString", not "getMessage"
        String msg = t.toString(); // Not getMessage, so no violation
        out.write(msg);
    }
}