// A Writer flowing into a StringWriter should not be flagged as resource leak.
package scensct.core.neg;

import java.io.StringWriter;
import java.io.Writer;

public class NegCase3 {
    public static void main(String[] args) {
        // Scenario 3: Writer (could be any subtype) is wrapped by StringWriter.
        Writer baseWriter = new StringWriter();
        StringWriter wrappingWriter = new StringWriter();
        // Simulate flow: baseWriter is used to construct or wrap, but here we show assignment.
        // Minimal flow: baseWriter's target is an in-memory type.
        wrappingWriter.append("data");
        System.out.println(wrappingWriter.toString());
    }
}