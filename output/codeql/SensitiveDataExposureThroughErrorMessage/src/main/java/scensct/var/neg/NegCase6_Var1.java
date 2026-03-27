// Throwable.getMessage() result flows to a non-HTTP response sink should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase6_Var1 {
    // Variant 1: Lexical refactoring with temporary variable and explicit type
    public void handleError(Throwable t) {
        final String errorDetail = t.getMessage();
        System.err.println(errorDetail);
    }
}