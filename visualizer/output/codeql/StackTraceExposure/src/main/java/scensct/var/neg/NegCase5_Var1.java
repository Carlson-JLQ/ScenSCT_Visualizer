// A printStackTrace() call with no arguments, and any PrintWriter-on-StringWriter configuration present does not have the correct relationship should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase5_Var1 {
    public static void main(String[] args) {
        // Swap declaration order, introduce an unused temporary.
        PrintWriter pw = new PrintWriter(System.out);
        StringWriter sw = new StringWriter();
        // Restructure try-catch: separate block for exception creation.
        RuntimeException ex = new RuntimeException("test");
        try {
            throw ex;
        } catch (RuntimeException e) {
            // Direct call preserved.
            e.printStackTrace();
        }
        // sw remains unused.
    }
}