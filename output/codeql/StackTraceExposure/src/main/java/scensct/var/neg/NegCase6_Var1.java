// A method call that is not printStackTrace, and any PrintWriter-on-StringWriter configuration present is not used to print the stack trace of exception E should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase6_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring + temporary variable
        StringWriter buffer = new StringWriter();
        PrintWriter printer = new PrintWriter(buffer);
        String greeting = "Hello";
        printer.print(greeting);
        printer.println();
    }
}