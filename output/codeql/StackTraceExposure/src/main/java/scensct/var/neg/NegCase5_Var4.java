// A printStackTrace() call with no arguments, and any PrintWriter-on-StringWriter configuration present does not have the correct relationship should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase5_Var4 {
    public static void main(String[] args) {
        // Use try-with-resources for PrintWriter (but note: closing System.out is usually not done).
        // We'll avoid closing by not declaring in try-with-resources; instead, restructure.
        StringWriter sw = new StringWriter();
        PrintWriter pw;
        pw = new PrintWriter(System.out);
        // Add a dummy if-else that doesn't affect flow.
        if (args.length == 0) {
            // Normal path.
            try {
                throw new RuntimeException("test");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        } else {
            // Unreachable but syntactically present.
            System.err.println("unused");
        }
    }
}