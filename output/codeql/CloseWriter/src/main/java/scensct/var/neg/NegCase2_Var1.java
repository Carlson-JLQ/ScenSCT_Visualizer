// Creating a StringWriter (in-memory type) should not be flagged as resource leak.
package scensct.var.neg;

import java.io.StringWriter;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Variant 1: Use write() instead of append(), and restructure with a local variable.
        StringWriter sw = new StringWriter();
        sw.write("Hello");
        String result = sw.toString();
        System.out.println(result);
    }
}