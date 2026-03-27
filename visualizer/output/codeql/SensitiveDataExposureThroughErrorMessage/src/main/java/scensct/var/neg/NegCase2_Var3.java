// Calling a method other than a specific non-getMessage method M should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase2_Var3 {
    // Variant 3: Extract the writing to a helper method
    private void writeToOutput(PrintWriter writer, String content) {
        writer.write(content);
    }

    public void handleError(Throwable t, PrintWriter out) {
        String msg = t.getLocalizedMessage();
        writeToOutput(out, msg);
    }
}