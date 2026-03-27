// No method call MC, and any PrintWriter-on-StringWriter configuration present does not have the correct relationship should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase4_Var2 {
    // Variant 2: Extract PrintWriter creation to a helper method
    // Helper returns a PrintWriter not based on StringWriter.
    private static PrintWriter createSafeWriter() {
        return new PrintWriter(System.out);
    }

    public static void main(String[] args) {
        StringWriter sw = new StringWriter(); // Exists but unused with pw.
        PrintWriter pw = createSafeWriter();
        // No method call MC.
    }
}