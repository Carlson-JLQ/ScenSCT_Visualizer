// A method call that is not printStackTrace, and there exists a PrintWriter-on-StringWriter configuration where an exception's stack trace is printed to it, but the StringWriter is not converted to a string via toString() should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase8_Var3 {
    public static void main(String[] args) {
        // Variant 3: Use try-with-resources for PrintWriter, still no toString()
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            new IllegalArgumentException("test").printStackTrace(pw);
        }
        // sw exists but not turned to string
        System.out.println("Done");
    }
}