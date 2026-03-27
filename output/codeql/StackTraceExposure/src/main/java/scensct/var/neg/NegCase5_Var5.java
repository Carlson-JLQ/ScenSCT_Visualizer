// A printStackTrace() call with no arguments, and any PrintWriter-on-StringWriter configuration present does not have the correct relationship should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase5_Var5 {
    // Move the catch logic to a separate method, passing the exception.
    private static void handleException(RuntimeException e) {
        e.printStackTrace(); // Call site moved.
    }
    
    public static void main(String[] args) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(System.out);
        try {
            throw new RuntimeException("test");
        } catch (RuntimeException e) {
            handleException(e); // Delegated.
        }
        // sw still unrelated.
    }
}