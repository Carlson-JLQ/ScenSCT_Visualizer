// A method call that uses a format string argument but is not a call to String.format should not be flagged as a format string vulnerability.
package scensct.var.neg;

import java.util.Formatter;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Idiomatic variation - use Formatter with Appendable (StringBuilder).
        StringBuilder sb = new StringBuilder();
        try (Formatter formatter = new Formatter(sb)) {
            String taintedFormat = args[0];
            formatter.format(taintedFormat, "safeArg");
        } // try-with-resources auto-closes
        System.out.println(sb.toString());
    }
}