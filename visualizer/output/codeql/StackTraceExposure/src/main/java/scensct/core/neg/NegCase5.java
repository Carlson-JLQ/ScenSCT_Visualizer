// A printStackTrace() call with no arguments, and any PrintWriter-on-StringWriter configuration present does not have the correct relationship should not be flagged.
package scensct.core.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase5 {
    public static void main(String[] args) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(System.out); // Incorrect relationship.
        try {
            throw new RuntimeException("test");
        } catch (RuntimeException e) {
            e.printStackTrace(); // printStackTrace call, but configuration not related.
        }
    }
}