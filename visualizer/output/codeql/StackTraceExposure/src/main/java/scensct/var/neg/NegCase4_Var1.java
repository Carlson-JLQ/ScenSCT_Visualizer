// No method call MC, and any PrintWriter-on-StringWriter configuration present does not have the correct relationship should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase4_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical & control-flow restructuring
        // Introduce a conditional that never executes the dangerous path.
        StringWriter sw = null;
        PrintWriter pw = null;
        boolean flag = false;
        if (flag) {
            sw = new StringWriter();
            pw = new PrintWriter(sw); // This would be dangerous, but unreachable.
        } else {
            pw = new PrintWriter(System.out);
        }
        // Still no method call MC.
    }
}