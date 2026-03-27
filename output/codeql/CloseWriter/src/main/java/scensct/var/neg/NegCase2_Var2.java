// Creating a StringWriter (in-memory type) should not be flagged as resource leak.
package scensct.var.neg;

import java.io.StringWriter;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        // Variant 2: Wrap creation and usage in a conditional branch.
        StringWriter writer = null;
        if (args.length >= 0) { // Always true, but adds control flow
            writer = new StringWriter();
            writer.append("Hello");
        }
        if (writer != null) {
            System.out.println(writer.toString());
        }
    }
}