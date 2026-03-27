// Creating a StringWriter (in-memory type) should not be flagged as resource leak.
package scensct.var.neg;

import java.io.StringWriter;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        // Variant 4: Loop structure with multiple writes (still in-memory).
        StringWriter writer = new StringWriter();
        for (int i = 0; i < 1; i++) { // Single iteration
            writer.append("Hello");
        }
        System.out.println(writer.toString());
    }
}