// No method call MC, and any PrintWriter-on-StringWriter configuration present does not have the correct relationship should not be flagged.
package scensct.core.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase4 {
    public static void main(String[] args) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(System.out); // PrintWriter not constructed from StringWriter.
        // No method call MC, and configuration lacks correct relationship.
    }
}