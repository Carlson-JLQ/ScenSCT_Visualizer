// A printStackTrace() call with no arguments, and any PrintWriter-on-StringWriter configuration present does not have the correct relationship should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase5_Var3 {
    // Extract PrintWriter creation to a helper method.
    private static PrintWriter createConsoleWriter() {
        return new PrintWriter(System.out);
    }
    
    public static void main(String[] args) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = createConsoleWriter(); // Unrelated to sw.
        // Inline the exception creation.
        try {
            RuntimeException re = new RuntimeException("test");
            throw re;
        } catch (RuntimeException e) {
            e.printStackTrace(); // Still prints to console.
        }
    }
}