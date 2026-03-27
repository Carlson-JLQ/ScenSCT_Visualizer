// A method call that uses a format string argument but is not a call to String.format should not be flagged as a format string vulnerability.
package scensct.var.neg;

import java.util.Formatter;

public class NegCase1_Var3 {
    // Variant 3: Inter-procedural refactoring - extract formatting to a helper method.
    private static void formatWithFormatter(String format, Object arg) {
        Formatter formatter = new Formatter();
        formatter.format(format, arg);
        System.out.println(formatter.toString());
    }
    
    public static void main(String[] args) {
        String tainted = args[0];
        formatWithFormatter(tainted, "safeArg");
    }
}