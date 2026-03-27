// No method call MC, and any PrintWriter-on-StringWriter configuration present does not have the correct relationship should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase4_Var4 {
    // Variant 4: Loop and temporary variable, with benign dead code
    public static void main(String[] args) {
        StringWriter[] writers = new StringWriter[1];
        writers[0] = new StringWriter();
        PrintWriter pw = null;
        for (int i = 0; i < 1; i++) {
            pw = new PrintWriter(System.out); // Safe assignment.
            // No interaction with writers[i].
        }
        // No method call MC.
    }
}