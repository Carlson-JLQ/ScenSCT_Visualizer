// A method call that uses a format string argument but is not a call to String.format should not be flagged as a format string vulnerability.
package scensct.var.neg;

import java.util.Formatter;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Intra-procedural with try-catch and multiple statements.
        String tainted = args[0];
        Formatter formatter = new Formatter();
        try {
            formatter.format(tainted, "safeArg");
        } catch (Exception e) {
            // ignore
        } finally {
            System.out.println(formatter.toString());
        }
    }
}