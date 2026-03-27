// A printStackTrace() call with no arguments, and any PrintWriter-on-StringWriter configuration present does not have the correct relationship should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase5_Var2 {
    public static void main(String[] args) {
        // Introduce an alias for System.out.
        java.io.OutputStream outStream = System.out;
        PrintWriter pw = new PrintWriter(outStream);
        StringWriter sw = new StringWriter(); // Still unrelated.
        // Use a finally block after catching.
        try {
            throw new RuntimeException("test");
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            // Irrelevant cleanup.
            pw.flush();
        }
    }
}