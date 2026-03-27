// Creating a StringWriter (in-memory type) should not be flagged as resource leak.
package scensct.core.neg;

import java.io.StringWriter;

public class NegCase2 {
    public static void main(String[] args) {
        // Scenario 2: StringWriter is an in-memory Writer, no external resource.
        StringWriter writer = new StringWriter();
        writer.append("Hello");
        System.out.println(writer.toString());
    }
}