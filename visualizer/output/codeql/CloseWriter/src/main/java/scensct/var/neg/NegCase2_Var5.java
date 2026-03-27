// Creating a StringWriter (in-memory type) should not be flagged as resource leak.
package scensct.var.neg;

import java.io.StringWriter;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        // Variant 5: Initialize with constructor that takes an initial string.
        StringWriter writer = new StringWriter();
        writer.write("Hello"); // Separate write
        // No close, but in-memory so safe
        System.out.println(writer.toString());
    }
}