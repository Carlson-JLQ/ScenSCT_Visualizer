// A Writer flowing into a StringWriter should not be flagged as resource leak.
package scensct.var.neg;

import java.io.StringWriter;
import java.io.Writer;

public class NegCase3_Var1 {
    private static void writeData(Writer w) {
        if (w instanceof StringWriter) {
            ((StringWriter) w).append("sample");
        }
    }

    public static void main(String[] args) {
        Writer writer = new StringWriter();
        writeData(writer);
        System.out.println(((StringWriter) writer).toString());
    }
}