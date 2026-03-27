// A method call that is not printStackTrace, and any PrintWriter-on-StringWriter configuration present is not used to print the stack trace of exception E should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase6_Var3 {
    // Variant 3: Inter-procedural extraction
    private static void writeMessage(PrintWriter pw, String msg) {
        pw.println(msg);
    }

    public static void main(String[] args) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        writeMessage(pw, "Hello");
    }
}