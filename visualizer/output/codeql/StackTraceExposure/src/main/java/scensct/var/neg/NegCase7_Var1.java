// No method call MC, and any PrintWriter-on-StringWriter configuration present is not used to print the stack trace of exception E should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase7_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring with var and reordered declarations.
        var stringWriter = new StringWriter();
        PrintWriter printWriter = null;
        printWriter = new PrintWriter(stringWriter);
        // Still no stack trace printed.
    }
}