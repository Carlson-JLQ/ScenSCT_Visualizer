// Creating a StringWriter (in-memory type) should not be flagged as resource leak.
package scensct.var.neg;

import java.io.StringWriter;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        // Variant 3: Extract usage to a helper method.
        StringWriter writer = new StringWriter();
        useWriter(writer);
        System.out.println(writer.toString());
    }

    private static void useWriter(StringWriter w) {
        w.append("Hello");
    }
}