// No method call MC, and any PrintWriter-on-StringWriter configuration present does not have the correct relationship should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase4_Var5 {
    // Variant 5: Introduce a dummy exception and catch it, but still no printStackTrace call.
    public static void main(String[] args) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(System.out);
            throw new RuntimeException("test"); // thrown but caught
        } catch (RuntimeException e) {
            // e.printStackTrace(); // deliberately omitted
            // So no method call MC.
        }
    }
}