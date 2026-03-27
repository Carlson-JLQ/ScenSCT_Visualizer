// A Writer flowing into a StringWriter should not be flagged as resource leak.
package scensct.var.neg;

import java.io.StringWriter;
import java.io.Writer;

public class NegCase3_Var2 {
    public static void main(String[] args) {
        Writer result = null;
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                result = new StringWriter();
            }
        }
        if (result == null) {
            result = new StringWriter();
        }
        ((StringWriter) result).write("test");
        System.out.println(result.toString());
    }
}